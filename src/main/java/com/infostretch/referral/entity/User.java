package com.infostretch.referral.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  /** The email. */
  @Column(length = 200)
  private String email;

  /** The name. */
  @Column(length = 200)
  private String name;

  /** The password. */
  @Column(length = 200)
  private String password;

  /** The firstname. */
  @Column(length = 100)
  private String firstname;

  /** The lastname. */
  @Column(length = 100)
  private String lastname;

  /** The employee referralsCreated. */
  // bi-directional many-to-one association to EmployeeReferral
  @OneToMany(mappedBy = "createdBy")
  private List<EmployeeReferral> employeeReferralsCreated;

  /** The employee referrals2. */
  // bi-directional many-to-one association to EmployeeReferral
  @OneToMany(mappedBy = "updatedBy")
  private List<EmployeeReferral> employeeReferralsUpdated;

  /** The sales referralsCreated. */
  // bi-directional many-to-one association to SalesReferral
  @OneToMany(mappedBy = "createdBy")
  private List<SalesReferral> salesReferralsCreated;

  /** The sales referrals2. */
  // bi-directional many-to-one association to SalesReferral
  @OneToMany(mappedBy = "updatedBy")
  private List<SalesReferral> salesReferralsUpdated;

  /** The user role mappings. */
  // bi-directional many-to-one association to UserRoleMapping
  @OneToMany(mappedBy = "user")
  private List<UserRoleMapping> userRoleMappings;

  /**
   * Instantiates a new user.
   */
  public User() {
  }

  /**
   * @return the employeeReferralsCreated
   */
  public List<EmployeeReferral> getEmployeeReferralsCreated() {
    return this.employeeReferralsCreated;
  }

  /**
   * @param employeeReferralsCreated
   *          the employeeReferralsCreated to set
   */
  public void setEmployeeReferralsCreated(final List<EmployeeReferral> employeeReferrals) {
    this.employeeReferralsCreated = employeeReferrals;
  }

  /**
   * @return the employeeReferralsUpdated
   */
  public List<EmployeeReferral> getEmployeeReferralsUpdated() {
    return this.employeeReferralsUpdated;
  }

  /**
   * @param employeeReferralsUpdated
   *          the employeeReferralsUpdated to set
   */
  public void setEmployeeReferralsUpdated(final List<EmployeeReferral> employeeReferrals) {
    this.employeeReferralsUpdated = employeeReferrals;
  }

  /**
   * @return the salesReferralsCreated
   */
  public List<SalesReferral> getSalesReferralsCreated() {
    return this.salesReferralsCreated;
  }

  /**
   * @param salesReferralsCreated
   *          the salesReferralsCreated to set
   */
  public void setSalesReferralsCreated(final List<SalesReferral> salesReferrals) {
    this.salesReferralsCreated = salesReferrals;
  }

  /**
   * @return the salesReferralsUpdated
   */
  public List<SalesReferral> getSalesReferralsUpdated() {
    return this.salesReferralsUpdated;
  }

  /**
   * @param salesReferralsUpdated
   *          the salesReferralsUpdated to set
   */
  public void setSalesReferralsUpdated(final List<SalesReferral> salesReferrals) {
    this.salesReferralsUpdated = salesReferrals;
  }

  /**
   * Adds the employee referralsCreated.
   *
   * @param employeeReferralsCreated
   *          the employee referralsCreated
   * @return the employee referral
   */
  public EmployeeReferral addEmployeeReferralsCreated(
      final EmployeeReferral employeeReferralsCreated1) {
    this.getEmployeeReferralsCreated().add(employeeReferralsCreated1);
    employeeReferralsCreated1.setCreatedBy(this);

    return employeeReferralsCreated1;
  }

  /**
   * Adds the employee referrals2.
   *
   * @param employeeReferrals2
   *          the employee referrals2
   * @return the employee referral
   */
  public EmployeeReferral addEmployeeReferrals2(final EmployeeReferral employeeReferralsUpdated1) {
    this.getEmployeeReferralsUpdated().add(employeeReferralsUpdated1);
    employeeReferralsUpdated1.setUpdatedBy(this);

    return employeeReferralsUpdated1;
  }

  /**
   * Adds the sales referralsCreated.
   *
   * @param salesReferralsCreated
   *          the sales referralsCreated
   * @return the sales referral
   */
  public SalesReferral addSalesReferralsCreated(final SalesReferral salesReferralsCreated2) {
    this.getSalesReferralsCreated().add(salesReferralsCreated2);
    salesReferralsCreated2.setCreatedBy(this);

    return salesReferralsCreated2;
  }

  /**
   * Adds the sales referrals2.
   *
   * @param salesReferrals2
   *          the sales referrals2
   * @return the sales referral
   */
  public SalesReferral addSalesReferrals2(final SalesReferral salesReferralsUpdated2) {
    this.getSalesReferralsUpdated().add(salesReferralsUpdated2);
    salesReferralsUpdated2.setUpdatedBy(this);

    return salesReferralsUpdated2;
  }

  /**
   * Adds the user role mapping.
   *
   * @param userRoleMapping
   *          the user role mapping
   * @return the user role mapping
   */
  public UserRoleMapping addUserRoleMapping(final UserRoleMapping userRoleMapping) {
    this.getUserRoleMappings().add(userRoleMapping);
    userRoleMapping.setUser(this);

    return userRoleMapping;
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
   * Gets the firstname.
   *
   * @return the firstname
   */
  public String getFirstname() {
    return this.firstname;
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
   * Gets the lastname.
   *
   * @return the lastname
   */
  public String getLastname() {
    return this.lastname;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Gets the user role mappings.
   *
   * @return the user role mappings
   */
  public List<UserRoleMapping> getUserRoleMappings() {
    return this.userRoleMappings;
  }

  /**
   * Removes the employee referralsCreated.
   *
   * @param employeeReferralsCreated
   *          the employee referralsCreated
   * @return the employee referral
   */
  public EmployeeReferral removeEmployeeReferralsCreated(
      final EmployeeReferral employeeReferralsCreated1) {
    this.getEmployeeReferralsCreated().remove(employeeReferralsCreated1);
    employeeReferralsCreated1.setCreatedBy(null);

    return employeeReferralsCreated1;
  }

  /**
   * Removes the employee referrals2.
   *
   * @param employeeReferrals2
   *          the employee referrals2
   * @return the employee referral
   */
  public EmployeeReferral removeEmployeeReferrals2(final EmployeeReferral employeeReferralsUpdated1) {
    this.getEmployeeReferralsUpdated().remove(employeeReferralsUpdated1);
    employeeReferralsUpdated1.setUpdatedBy(null);

    return employeeReferralsUpdated1;
  }

  /**
   * Removes the sales referralsCreated.
   *
   * @param salesReferralsCreated
   *          the sales referralsCreated
   * @return the sales referral
   */
  public SalesReferral removeSalesReferralsCreated(final SalesReferral salesReferralsCreated2) {
    this.getSalesReferralsCreated().remove(salesReferralsCreated2);
    salesReferralsCreated2.setCreatedBy(this);

    return salesReferralsCreated2;
  }

  /**
   * Removes the sales referrals2.
   *
   * @param salesReferrals2
   *          the sales referrals2
   * @return the sales referral
   */
  public SalesReferral removeSalesReferrals2(final SalesReferral salesReferralsUpdated2) {
    this.getSalesReferralsUpdated().remove(salesReferralsUpdated2);
    salesReferralsUpdated2.setUpdatedBy(null);

    return salesReferralsUpdated2;
  }

  /**
   * Removes the user role mapping.
   *
   * @param userRoleMapping
   *          the user role mapping
   * @return the user role mapping
   */
  public UserRoleMapping removeUserRoleMapping(final UserRoleMapping userRoleMapping) {
    this.getUserRoleMappings().remove(userRoleMapping);
    userRoleMapping.setUser(null);

    return userRoleMapping;
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
   * Sets the firstname.
   *
   * @param firstname
   *          the new firstname
   */
  public void setFirstname(final String firstname) {
    this.firstname = firstname;
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
   * Sets the lastname.
   *
   * @param lastname
   *          the new lastname
   */
  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the password.
   *
   * @param password
   *          the new password
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Sets the user role mappings.
   *
   * @param userRoleMappings
   *          the new user role mappings
   */
  public void setUserRoleMappings(final List<UserRoleMapping> userRoleMappings) {
    this.userRoleMappings = userRoleMappings;
  }
}
