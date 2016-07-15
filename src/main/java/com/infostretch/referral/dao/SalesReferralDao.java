package com.infostretch.referral.dao;

import java.util.List;

import com.infostretch.referral.commons.SalesReferralDetails;
import com.infostretch.referral.entity.SalesReferral;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * The Interface SalesReferralDao.
 *
 * @author aneri.parikh
 */
public interface SalesReferralDao extends GenericDao<SalesReferral> {

  /**
   * Gets the sales referral details.
   *
   * @return the sales referral details
   * @throws RESTServiceException
   *           the REST service exception
   */
  List<SalesReferralDetails> getSalesReferralDetails() throws RESTServiceException;

  /**
   * Gets the salese referral details by created by role.
   *
   * @param createdBy
   *          the created by
   * @return the salese referral details by created by role
   * @throws RESTServiceException
   *           the REST service exception
   */
  List<SalesReferralDetails> getSaleseReferralDetailsByCreatedByRole(Integer createdBy)
      throws RESTServiceException;
}
