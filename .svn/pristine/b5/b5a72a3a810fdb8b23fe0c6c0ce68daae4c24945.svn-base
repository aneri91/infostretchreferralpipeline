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
 * The persistent class for the role database table.
 *
 */
@Entity
@Table(name = "role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  /** The role name. */
  @Column(name = "role_name", length = 200)
  private String roleName;

  /** The user role mappings. */
  // bi-directional many-to-one association to UserRoleMapping
  @OneToMany(mappedBy = "role")
  private List<UserRoleMapping> userRoleMappings;

  /**
   * Instantiates a new role.
   */
  public Role() {
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
    userRoleMapping.setRole(this);

    return userRoleMapping;
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
   * Gets the role name.
   *
   * @return the role name
   */
  public String getRoleName() {
    return this.roleName;
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
   * Removes the user role mapping.
   *
   * @param userRoleMapping
   *          the user role mapping
   * @return the user role mapping
   */
  public UserRoleMapping removeUserRoleMapping(final UserRoleMapping userRoleMapping) {
    this.getUserRoleMappings().remove(userRoleMapping);
    userRoleMapping.setRole(null);

    return userRoleMapping;
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
   * Sets the role name.
   *
   * @param roleName
   *          the new role name
   */
  public void setRoleName(final String roleName) {
    this.roleName = roleName;
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
