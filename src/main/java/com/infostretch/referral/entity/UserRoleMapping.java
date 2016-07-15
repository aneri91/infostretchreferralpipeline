package com.infostretch.referral.entity;

import java.io.Serializable;

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

/**
 * The persistent class for the user_role_mapping database table.
 *
 */
@Entity
@Table(name = "user_role_mapping")
@NamedQuery(name = "UserRoleMapping.findAll", query = "SELECT u FROM UserRoleMapping u")
public class UserRoleMapping implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private int id;

  /** The role. */
  // bi-directional many-to-one association to Role
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  /** The user. */
  // bi-directional many-to-one association to User
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  /**
   * Instantiates a new user role mapping.
   */
  public UserRoleMapping() {
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
   * Gets the role.
   *
   * @return the role
   */
  public Role getRole() {
    return this.role;
  }

  /**
   * Gets the user.
   *
   * @return the user
   */
  public User getUser() {
    return this.user;
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
   * Sets the role.
   *
   * @param role
   *          the new role
   */
  public void setRole(final Role role) {
    this.role = role;
  }

  /**
   * Sets the user.
   *
   * @param user
   *          the new user
   */
  public void setUser(final User user) {
    this.user = user;
  }

}
