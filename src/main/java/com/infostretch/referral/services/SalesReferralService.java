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

import com.infostretch.referral.commons.SalesReferralDTO;
import com.infostretch.referral.commons.SalesReferralResponseDTO;
import com.infostretch.referral.commons.Status;
import com.infostretch.referral.commons.StatusDTO;
import com.infostretch.referral.commons.UpdateSalesStatusRequestDTO;
import com.infostretch.referral.dao.SalesReferralDao;
import com.infostretch.referral.dao.UserDao;
import com.infostretch.referral.entity.SalesReferral;
import com.infostretch.referral.entity.User;
import com.infostretch.referral.exception.RESTServiceException;
import com.infostretch.referral.utilities.Constants;
import com.infostretch.referral.utilities.SendMail;

/**
 * The Class SalesReferralService. service for<br/>
 *
 * saving sales Referral information<br/>
 *
 * validating<br/>
 *
 * sending mails to Sales Admin<br/>
 *
 * @author aneri.parikh
 */
@Service
public class SalesReferralService {
  /** The log. */
  private static final Log LOG = LogFactory.getLog(SalesReferralService.class);
  /** The sales referral dao. */
  @Autowired
  private SalesReferralDao salesReferralDao;

  /** The user dao. */
  @Autowired
  private UserDao userDao;

  /** The velocity engine. */
  @Autowired
  private VelocityEngine velocityEngine;

  /** The send mail. */
  @Autowired
  private SendMail sendMail;

  /**
   * Instantiates a new sales referral service.
   */
  public SalesReferralService() {
  }

  /**
   * Save sales referral.
   *
   * @param salesReferralDTO
   *          the sales referral dto
   * @return the status dto
   */
  public StatusDTO saveSalesReferral(final SalesReferralDTO salesReferralDTO) {
    // creates object of StatusDTO
    final StatusDTO status = new StatusDTO();
    final SalesReferral salesReferral = new SalesReferral();
    // sets all values
    salesReferral.setCompanyName(salesReferralDTO.getCompanyName());
    salesReferral.setEmail(salesReferralDTO.getEmail());
    salesReferral.setContactName(salesReferralDTO.getContactName());
    salesReferral.setPhone(salesReferralDTO.getPhone());
    salesReferral.setComments(salesReferralDTO.getComments());
    salesReferral.setCreatedOn(new Date());
    salesReferral.setUpdatedOn(new Date());
    // finding id of createdBy
    final User createdBy = this.userDao.findById(salesReferralDTO.getCreatedBy());
    // saving sales referral object
    salesReferral.setCreatedBy(createdBy);
    this.salesReferralDao.save(salesReferral);
    final Map<String, Object> model = new HashMap<String, Object>();

    model.put("companyName", salesReferralDTO.getCompanyName());
    model.put("contactName", salesReferralDTO.getContactName());
    model.put("email", salesReferralDTO.getEmail());
    model.put("phone", salesReferralDTO.getPhone());
    model.put("comments", salesReferralDTO.getComments());
    model.put("createdOn", salesReferral.getCreatedOn());
    model.put("createdBy", createdBy.getFirstname() + " " + createdBy.getLastname());

    final String body = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine,
        "/templates/salesReferralTemplate.vm", "UTF-8", model);
    final String[] to = { "pratik.oza@infostretch.com", "aneri.parikh@infostretch.com",
        "vaibhavi.joshi@infostretch.com", "mudita.tiwari@infostretch.com",
        "pooja.arondekar@infostretch.com", };
    // sending mail
    this.sendMail.sendEmail(to, body, "aneri.parikh@infostretch.com", "New Referral Information");
    // 200 OK
    status.setStatus(new Status("success"));
    return status;

  }

  /**
   * Gets the sales referrals.
   *
   * @param role
   *          the role
   * @param createdBy
   *          the created by
   * @return the sales referrals
   */
  public SalesReferralResponseDTO getSalesReferrals(final String role, final Integer createdBy) {
    final SalesReferralResponseDTO salesReferralResponseDTO = new SalesReferralResponseDTO();
    try {
      // validation with mandatory fields
      Validate.notNull(createdBy, "invalid_createdBy");
      Validate.notEmpty(role, "invalid_role");

    } catch (final NullPointerException | IllegalArgumentException e) {
      salesReferralResponseDTO.setStatus(new Status(e.getMessage(), 400));
      return salesReferralResponseDTO;
    }
    try {
      // sales.admin equality
      if (role.equalsIgnoreCase(Constants.ROLE_SALES_ADMIN)) {
        // returns all details
        salesReferralResponseDTO.setData(this.salesReferralDao.getSalesReferralDetails());
      } else {
        // returns sales referral by role
        salesReferralResponseDTO.setData(this.salesReferralDao
            .getSaleseReferralDetailsByCreatedByRole(createdBy));
      }
      salesReferralResponseDTO.setStatus(new Status("success"));
    } catch (final RESTServiceException e) {
      salesReferralResponseDTO.setStatus(new Status("Server_Error",
          HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
      LOG.error("Error in server ", e);
    }
    return salesReferralResponseDTO;
  }

  /**
   * Update sales referral status.
   *
   * @param updateSalesStatusRequestDTO
   *          the update sales status request dto
   * @return the status dto
   */
  public StatusDTO updateSalesReferralStatus(
      final UpdateSalesStatusRequestDTO updateSalesStatusRequestDTO) {
    final StatusDTO status = new StatusDTO();
    // findBycontactId
    final SalesReferral salesReferral = this.salesReferralDao.findById(updateSalesStatusRequestDTO
        .getContactId());
    if (salesReferral != null) {
      // sets all values
      salesReferral.setId(updateSalesStatusRequestDTO.getContactId());
      salesReferral.setIsContact(updateSalesStatusRequestDTO.getIsContact());
      salesReferral.setIsViable(updateSalesStatusRequestDTO.getIsViable());
      salesReferral.setIsClose(updateSalesStatusRequestDTO.getIsClose());
      // finding id of updatedBy
      final User updatedBy = this.userDao.findById(updateSalesStatusRequestDTO.getUpdatedBy());
      salesReferral.setUpdatedBy(updatedBy);
      salesReferral.setUpdatedOn(new Date());
      this.salesReferralDao.update(salesReferral);
      status.setStatus(new Status("success"));
    } else {
      status.setStatus(new Status("Server_Error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
    }

    return status;
  }
}
