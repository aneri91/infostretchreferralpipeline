package com.infostretch.referral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infostretch.referral.commons.LoginInputDTO;
import com.infostretch.referral.commons.LoginResponseDTO;
import com.infostretch.referral.services.LoginService;

/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
  /** The login service. */
  // login service
  @Autowired
  private LoginService loginService;

  /**
   * Instantiates a new login controller.
   */
  public LoginController() {
  }

  /**
   * Login authentication.
   *
   * @param loginDTO
   *          the login dto
   * @return the login response dto
   */

  @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  @ResponseBody
  public LoginResponseDTO loginAuthentication(@RequestBody final LoginInputDTO loginDTO) {
    return this.loginService.validUser(loginDTO);
  }

}
