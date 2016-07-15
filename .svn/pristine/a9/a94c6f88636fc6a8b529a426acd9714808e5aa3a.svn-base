package com.infostretch.referral.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.infostretch.referral.utilities.ObjectUtils;

/**
 * The persistent class for the sales_referral database table.
 *
 */
@Entity
@Table(name = "sales_referral")
@NamedQuery(name = "SalesReferral.findAll", query = "SELECT s FROM SalesReferral s")
public class SalesReferral implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  /** The comments. */
  private String comments;

  /** The company name. */
  @Column(name = "company_name", length = 500)
  private String companyName;

  /** The contact name. */
  @Column(name = "contact_name", length = 200)
  private String contactName;

  /** The created on. */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on")
  private Date createdOn;

  /** The email. */
  @Column(length = 200)
  private String email;

  /** The is close. */
  @Column(name = "is_close")
  private boolean isClose;

  /** The is contact. */
  @Column(name = "is_contact")
  private boolean isContact;

  /** The is viable. */
  @Column(name = "is_viable")
  private boolean isViable;

  /** The phone. */
  @Column(length = 20)
  private String phone;

  /** The updated on. */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_on")
  private Date updatedOn;

  /** The created by. */
  // bi-directional many-to-one association to User
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by")
  private User createdBy;

  /** The updated by. */
  // bi-directional many-to-one association to User
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "updated_by")
  private User updatedBy;

  /**
   * Instantiates a new sales referral.
   */
  public SalesReferral() {
  }

  /**
   * Gets the comments.
   *
   * @return the comments
   */
  public Object getComments() {
    return this.comments;
  }

  /**
   * Gets the company name.
   *
   * @return the company name
   */
  public String getCompanyName() {
    return this.companyName;
  }

  /**
   * Gets the contact name.
   *
   * @return the contact name
   */
  public String getContactName() {
    return this.contactName;
  }

  /**
   * Gets the created by.
   *
   * @return the created by
   */
  public User getCreatedBy() {
    return this.createdBy;
  }

  /**
   * Gets the created on.
   *
   * @return the created on
   */
  public Date getCreatedOn() {
    return ObjectUtils.clone(this.createdOn);
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return this.id;
  }

  /**
   * Gets the checks if is close.
   *
   * @return the checks if is close
   */
  public Object getIsClose() {
    return this.isClose;
  }

  /**
   * Gets the checks if is contact.
   *
   * @return the checks if is contact
   */
  public Object getIsContact() {
    return this.isContact;
  }

  /**
   * Gets the checks if is viable.
   *
   * @return the checks if is viable
   */
  public Object getIsViable() {
    return this.isViable;
  }

  /**
   * Gets the phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return this.phone;
  }

  /**
   * Gets the updated by.
   *
   * @return the updated by
   */
  public User getUpdatedBy() {
    return this.updatedBy;
  }

  /**
   * Gets the updated on.
   *
   * @return the updated on
   */
  public Date getUpdatedOn() {
    return ObjectUtils.clone(this.updatedOn);
  }

  /**
   * Sets the comments.
   *
   * @param comments
   *          the new comments
   */
  public void setComments(final String comments) {
    this.comments = comments;
  }

  /**
   * Sets the company name.
   *
   * @param companyName
   *          the new company name
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
  }

  /**
   * Sets the contact name.
   *
   * @param contactName
   *          the new contact name
   */
  public void setContactName(final String contactName) {
    this.contactName = contactName;
  }

  /**
   * Sets the created by.
   *
   * @param createdBy
   *          the new created by
   */
  public void setCreatedBy(final User createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Sets the created on.
   *
   * @param createdOn
   *          the new created on
   */
  public void setCreatedOn(final Date createdOn) {
    this.createdOn = ObjectUtils.clone(createdOn);
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Sets the checks if is close.
   *
   * @param isClose
   *          the new checks if is close
   */
  public void setIsClose(final boolean isClose) {
    this.isClose = isClose;
  }

  /**
   * Sets the checks if is contact.
   *
   * @param isContact
   *          the new checks if is contact
   */
  public void setIsContact(final boolean isContact) {
    this.isContact = isContact;
  }

  /**
   * Sets the checks if is viable.
   *
   * @param isViable
   *          the new checks if is viable
   */
  public void setIsViable(final boolean isViable) {
    this.isViable = isViable;
  }

  /**
   * Sets the phone.
   *
   * @param phone
   *          the new phone
   */
  public void setPhone(final String phone) {
    this.phone = phone;
  }

  /**
   * Sets the updated by.
   *
   * @param updatedBy
   *          the new updated by
   */
  public void setUpdatedBy(final User updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * Sets the updated on.
   *
   * @param updatedOn
   *          the new updated on
   */
  public void setUpdatedOn(final Date updatedOn) {
    this.updatedOn = ObjectUtils.clone(updatedOn);
  }
}
