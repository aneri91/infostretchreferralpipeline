package com.infostretch.referral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.infostretch.referral.commons.SalesReferralDetails;
import com.infostretch.referral.entity.SalesReferral;
import com.infostretch.referral.exception.RESTServiceException;

/**
 * The Class SalesReferralDaoImpl.
 *
 * @author aneri.parikh
 */
@Repository("salesReferralDao")
public class SalesReferralDaoImpl extends GenericDaoImpl<SalesReferral> implements SalesReferralDao {
  /** The entity manager. */
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Instantiates a new sales referral dao impl.
   */
  public SalesReferralDaoImpl() {
    super(SalesReferral.class);
  }

  /**
   * Gets the sales referral details.
   *
   * @return the sales referral details
   * @throws RESTServiceException
   *           the REST service exception
   * @see com.infostretch.referral.dao.SalesReferralDao#getSalesReferralDetails()
   */

  @SuppressWarnings("unchecked")
  @Override
  public List<SalesReferralDetails> getSalesReferralDetails() throws RESTServiceException {
    final Query query = this.entityManager
        .createQuery("SELECT new com.infostretch.referral.commons.SalesReferralDetails("
            + "s.id,s.contactName,s.companyName,s.isContact,s.isViable,s.isClose) "
            + "FROM SalesReferral s");
    final List<SalesReferralDetails> result = query.getResultList();
    return result;
  }

  /**
   * Gets the sales referral details by created by role.
   *
   * @param createdBy
   *          the created by
   * @return the salese referral details by created by role
   * @throws RESTServiceException
   *           the REST service exception
   * @see com.infostretch.referral.dao.SalesReferralDao#getSaleseReferralDetailsByCreatedByRole(java.
   *      lang.Integer)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<SalesReferralDetails> getSaleseReferralDetailsByCreatedByRole(final Integer createdBy)
      throws RESTServiceException {
    // Query
    final Query query = this.entityManager
        .createQuery("SELECT new com.infostretch.referral.commons.SalesReferralDetails("
            + "s.id,s.contactName,s.companyName,s.isContact,s.isViable,s.isClose) FROM "
            + "SalesReferral s WHERE s.createdBy.id=:createdBy");
    query.setParameter("createdBy", createdBy);
    // Get the List of Sales Referral by Role
    final List<SalesReferralDetails> result = query.getResultList();
    return result;
  }
}
