/**
 *
 */
package com.infostretch.referral.commons;

/**
 * The Class SalesReferralInputDetailsDTO.
 *
 * @author aneri.parikh
 */
public class SalesReferralDetails {

  /** The is close. */
  private Boolean isClose;

  /** The is contact. */
  private Boolean isContact;

  /** The is viable. */
  private Boolean isViable;

  /** The candidate id. */
  private Integer contactId;

  /** The candidate name. */
  private String contactName;

  /** The company name. */
  private String companyName;

  /**
   * Instantiates a new sales referral details.
   */
  public SalesReferralDetails() {
  }

  /**
   * Instantiates a new sales referral details.
   *
   * @param contactId
   *          the contact id
   * @param contactName
   *          the contact name
   * @param companyName
   *          the company name
   * @param isContact
   *          the is contact
   * @param isViable
   *          the is viable
   * @param isClose
   *          the is close
   */
  public SalesReferralDetails(final Integer contactId, final String contactName,
      final String companyName, final Boolean isContact, final Boolean isViable,
      final Boolean isClose) {
    this.contactName = contactName;
    this.contactId = contactId;
    this.companyName = companyName;
    this.isClose = isClose;
    this.isContact = isContact;
    this.isViable = isViable;
  }

  /**
   * Gets the checks if is close.
   *
   * @return the isClose
   */
  public Boolean getIsClose() {
    return this.isClose;
  }

  /**
   * Sets the checks if is close.
   *
   * @param isClose
   *          the isClose to set
   */
  public void setIsClose(final Boolean isClose) {
    this.isClose = isClose;
  }

  /**
   * Gets the checks if is contact.
   *
   * @return the isContact
   */
  public Boolean getIsContact() {
    return this.isContact;
  }

  /**
   * Sets the checks if is contact.
   *
   * @param isContact
   *          the isContact to set
   */
  public void setIsContact(final Boolean isContact) {
    this.isContact = isContact;
  }

  /**
   * Gets the checks if is viable.
   *
   * @return the isViable
   */
  public Boolean getIsViable() {
    return this.isViable;
  }

  /**
   * Sets the checks if is viable.
   *
   * @param isViable
   *          the isViable to set
   */
  public void setIsViable(final Boolean isViable) {
    this.isViable = isViable;
  }

  /**
   * Gets the contact id.
   *
   * @return the contactId
   */
  public Integer getContactId() {
    return this.contactId;
  }

  /**
   * Sets the contact id.
   *
   * @param contactId
   *          the contactId to set
   */
  public void setContactId(final Integer contactId) {
    this.contactId = contactId;
  }

  /**
   * Gets the contact name.
   *
   * @return the contactName
   */
  public String getContactName() {
    return this.contactName;
  }

  /**
   * Sets the contact name.
   *
   * @param contactName
   *          the contactName to set
   */
  public void setContactName(final String contactName) {
    this.contactName = contactName;
  }

  /**
   * Gets the company name.
   *
   * @return the companyName
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * Sets the company name.
   *
   * @param companyName
   *          the companyName to set
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

}
