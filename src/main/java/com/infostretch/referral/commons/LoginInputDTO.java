package com.infostretch.referral.commons;


/**
 * The Class LoginInputDTO.
 */
public class LoginInputDTO {
  /** The username. */
  private String username;

  /** The password. */
  private String password;

  /**
   * Instantiates a new login input dto.
   */
  public LoginInputDTO() {
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
   * Gets the username.
   *
   * @return the username
   */
  public String getUsername() {
    return this.username;
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
   * Sets the username.
   *
   * @param username
   *          the new username
   */

  public void setUsername(final String username) {
    this.username = username;
  }
}
