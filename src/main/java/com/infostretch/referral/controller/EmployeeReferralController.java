package com.infostretch.referral.controller;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infostretch.referral.commons.EmployeeReferralDTO;
import com.infostretch.referral.commons.EmployeeReferralResponseDTO;
import com.infostretch.referral.commons.StatusDTO;
import com.infostretch.referral.commons.UpdateEmployeeStatusRequestDTO;
import com.infostretch.referral.services.EmployeeReferralService;

/**
 * The Class EmployeeReferralController.<br/>
 * Saving Employee Referrals information
 *
 * @author aneri.parikh
 */
@Controller
public class EmployeeReferralController {
  /** The employee referral service. */
  @Autowired
  private EmployeeReferralService employeeReferralService;

  /**
   * Instantiates a new employee referral controller.
   */
  public EmployeeReferralController() {
  }

  /**
   * Gets the employee referrals detail.
   *
   * @param createdBy
   *          the created by
   * @param role
   *          the role
   * @return the employee referrals detail
   */
  @RequestMapping(value = "/employeereferrals", method = RequestMethod.GET)
  @ResponseBody
  public EmployeeReferralResponseDTO getEmployeeReferralsDetail(
      @RequestParam(value = "createdBy", required = false) final Integer createdBy,
      @RequestParam(value = "role", required = false) final String role) {
    return this.employeeReferralService.getEmployeeReferral(createdBy, role);
  }

  /**
   * Save employee referral.
   *
   * @param employeeReferralDTO
   *          the employee referral dto
   * @return the status dto
   */
  @RequestMapping(value = "/employeereferral", method = RequestMethod.POST,
      consumes = "application/json")
  @ResponseBody
  public StatusDTO saveEmployeeReferral(
      @RequestBody final EmployeeReferralDTO employeeReferralDTO) {
    try {
      // validation with mandatory fields
      Validate.notNull(employeeReferralDTO.getCandidateName(), "Invalid_candidateName");
      Validate.notNull(employeeReferralDTO.getEmail(), "Invalid_candidateEmail");
      Validate.notNull(employeeReferralDTO.getCreatedBy(), "Invalid_createdBy");
    } catch (final NullPointerException | IllegalArgumentException e) {
      return new StatusDTO(400, e.getMessage());
    }
    // saves Employee Referral information
    return this.employeeReferralService.saveEmployeeReferral(employeeReferralDTO);
  }

  /**
   * Update employee referral status.
   *
   * @param updateEmployeeStatusRequestDTO
   *          the update employee status request dto
   * @return the status dto
   */
  @RequestMapping(value = "/employeereferral/status", method = RequestMethod.PUT,
      consumes = "application/json")
  @ResponseBody
  public StatusDTO updateEmployeeReferralStatus(
      @RequestBody final UpdateEmployeeStatusRequestDTO updateEmployeeStatusRequestDTO) {
    try {
      // validation with mandatory fields
      Validate.notNull(updateEmployeeStatusRequestDTO.getCandidateId(), "Invalid_candidateId");
      Validate.notNull(updateEmployeeStatusRequestDTO.getIsContact(), "Invalid_isContact");
      Validate.notNull(updateEmployeeStatusRequestDTO.getIsViable(), "Invalid_isViable");
      Validate.notNull(updateEmployeeStatusRequestDTO.getIsClose(), "Invalid_isClose");
      Validate.notNull(updateEmployeeStatusRequestDTO.getUpdatedBy(), "Invalid_updatedBy");

    } catch (final NullPointerException | IllegalArgumentException e) {
      return new StatusDTO(400, e.getMessage());
    }
    return this.employeeReferralService
        .updateEmployeeReferralStatus(updateEmployeeStatusRequestDTO);
  }
}
