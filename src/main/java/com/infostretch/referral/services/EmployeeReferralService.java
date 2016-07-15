package com.infostretch.referral.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.infostretch.referral.commons.EmployeeReferralDTO;
import com.infostretch.referral.commons.EmployeeReferralResponseDTO;
import com.infostretch.referral.commons.Status;
import com.infostretch.referral.commons.StatusDTO;
import com.infostretch.referral.commons.UpdateEmployeeStatusRequestDTO;
import com.infostretch.referral.dao.EmployeeReferralDao;
import com.infostretch.referral.dao.UserDao;
import com.infostretch.referral.dao.UserRoleDao;
import com.infostretch.referral.entity.EmployeeReferral;
import com.infostretch.referral.entity.User;
import com.infostretch.referral.exception.RESTServiceException;
import com.infostretch.referral.utilities.Constants;
import com.infostretch.referral.utilities.SendMail;

/**
 * The Class EmployeeReferralService.
 *
 *
 *
 * service for<br/>
 *
 * employee Referral information<br/>
 *
 * which sends email to HR
 *
 * @author aneri.parikh
 */
@Service
public class EmployeeReferralService {
  /** The log. */
  private static final Log LOG = LogFactory.getLog(EmployeeReferralService.class);
  /** The employee referral dao. */
  @Autowired
  private EmployeeReferralDao employeeReferralDao;
  /** The user dao. */
  @Autowired
  private UserDao userDao;
  /** The velocity engine. */
  @Autowired
  private VelocityEngine velocityEngine;
  /** The send mail. */
  @Autowired
  private SendMail sendMail;
  /** The user role dao. */
  @Autowired
  private UserRoleDao userRoleDao;

  /**
   * Instantiates a new employee referral service.
   */
  public EmployeeReferralService() {
  }

  /**
   * Gets the employee referral.
   *
   * @param createdBy
   *          the created by
   * @param role
   *          the role
   * @return the employee referral
   */
  public EmployeeReferralResponseDTO getEmployeeReferral(final Integer createdBy, final String role) {
    final EmployeeReferralResponseDTO response = new EmployeeReferralResponseDTO();
    try {
      // validation with mandatory fields
      Validate.notNull(createdBy, "invalid_createdBy");
      Validate.notEmpty(role, "invalid_role");
    } catch (final NullPointerException | IllegalArgumentException e) {
      response.setStatus(new Status(e.getMessage(), 400));
      return response;
    }
    try {
      // hr.admin equality
      if (role.equalsIgnoreCase(Constants.ROLE_HR_ADMIN)) {
        // returns all details
        response.setData(this.employeeReferralDao.getEmployeeReferralDetails());
      } else {
        // returns employee referral by role
        response.setData(this.employeeReferralDao.getEmployeeReferralDetailsByCreatedBy(createdBy));
      }
      response.setStatus(new Status("success"));
    } catch (final RESTServiceException e) {
      response.setStatus(new Status("Server_Error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
      LOG.error("Exception : " + e.getMessage());
    }
    return response;
  }

  /**
   * Save employee referral.
   *
   * @param employeeReferralDTO
   *          the employee referral dto
   * @return the status dto
   */
  public StatusDTO saveEmployeeReferral(final EmployeeReferralDTO employeeReferralDTO) {
    // creates object of StatusDTO
    final StatusDTO status = new StatusDTO();
    final EmployeeReferral employeeReferral = new EmployeeReferral();
    employeeReferral.setCandidateName(employeeReferralDTO.getCandidateName());
    employeeReferral.setEmail(employeeReferralDTO.getEmail());
    employeeReferral.setLinkedinUrl(employeeReferralDTO.getLinkedinUrl());
    employeeReferral.setPhone(employeeReferralDTO.getPhone());
    employeeReferral.setCreatedOn(new Date());
    employeeReferral.setUpdatedOn(new Date());
    // finding id of createdBy
    final User createdBy = this.userDao.findById(employeeReferralDTO.getCreatedBy());
    employeeReferral.setCreatedBy(createdBy);
    // saving employee referral object
    this.employeeReferralDao.save(employeeReferral);
    final Map<String, Object> model = new HashMap<String, Object>();
    model.put("candidateName", employeeReferralDTO.getCandidateName());
    model.put("email", employeeReferralDTO.getEmail());
    model.put("phone", employeeReferralDTO.getPhone());
    model.put("linkedinUrl", employeeReferralDTO.getLinkedinUrl());
    LOG.info("LinkedURl=--" + employeeReferralDTO.getLinkedinUrl());
    model.put("createdOn", employeeReferral.getCreatedOn());
    model.put("createdBy", createdBy.getFirstname() + " " + createdBy.getLastname());
    final String body = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine,
        "/templates/employeeReferralTemplate.vm", "UTF-8", model);
    final String[] to = { "pratik.oza@infostretch.com", "aneri.parikh@infostretch.com",
        "vaibhavi.joshi@infostretch.com", "mudita.tiwari@infostretch.com",
        "pooja.arondekar@infostretch.com" };
    // sending mail
    this.sendMail.sendEmail(to, body, "aneri.parikh@infostretch.com", "New Referral Information");
    // 200 OK
    status.setStatus(new Status("success"));
    return status;
  }

  /**
   * Update employee referral status.
   *
   * @param updateEmployeeStatusRequestDTO
   *          the update employee status request dto
   * @return the status dto
   */
  public StatusDTO updateEmployeeReferralStatus(
      final UpdateEmployeeStatusRequestDTO updateEmployeeStatusRequestDTO) {
    final StatusDTO status = new StatusDTO();
    final EmployeeReferral employeeReferral = this.employeeReferralDao
        .findById(updateEmployeeStatusRequestDTO.getCandidateId());
    if (employeeReferral != null) {
      // sets all values
      employeeReferral.setId(updateEmployeeStatusRequestDTO.getCandidateId());
      employeeReferral.setIsContact(updateEmployeeStatusRequestDTO.getIsContact());
      employeeReferral.setIsViable(updateEmployeeStatusRequestDTO.getIsViable());
      employeeReferral.setIsClose(updateEmployeeStatusRequestDTO.getIsClose());
      // finding id of updatedBy
      final User updatedBy = this.userDao.findById(updateEmployeeStatusRequestDTO.getUpdatedBy());
      employeeReferral.setUpdatedBy(updatedBy);
      employeeReferral.setUpdatedOn(new Date());
      this.employeeReferralDao.update(employeeReferral);
      status.setStatus(new Status("success"));
    } else {
      status.setStatus(new Status("Server_Error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
    }

    return status;
  }
}
