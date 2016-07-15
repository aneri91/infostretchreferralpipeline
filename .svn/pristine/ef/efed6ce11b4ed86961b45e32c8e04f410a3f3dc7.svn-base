package com.infostretch.referral.dao;

import java.util.List;

import com.infostretch.referral.commons.EmployeeReferralDetails;
import com.infostretch.referral.entity.EmployeeReferral;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * The Interface EmployeeReferralDao.
 *
 * @author aneri.parikh
 */
public interface EmployeeReferralDao extends GenericDao<EmployeeReferral> {
  /**
   * Gets the employee referral details.
   *
   * @return the employee referral details
   * @throws RESTServiceException
   *           the REST service exception
   */
  List<EmployeeReferralDetails> getEmployeeReferralDetails() throws RESTServiceException;

  /**
   * Gets the employee referral details by created by.
   *
   * @param createdBy
   *          the created by
   * @return the employee referral details by created by
   * @throws RESTServiceException
   *           the REST service exception
   */
  List<EmployeeReferralDetails> getEmployeeReferralDetailsByCreatedBy(Integer createdBy)
      throws RESTServiceException;
}
