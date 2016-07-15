package com.infostretch.referral.utilities;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * The Class SendMail.
 */
@Component
@EnableAsync
public class SendMail {
  /** The log. */
  private static final Log LOG = LogFactory.getLog(SendMail.class);
  /** The velocity engine. */
  @Autowired
  private VelocityEngine velocityEngine;

  /** The mail sender. */
  @Autowired
  private JavaMailSender mailSender;

  /**
   * Instantiates a new send mail.
   */
  public SendMail() {
  }

  /**
   * Send email.
   *
   * @param to
   *          the to
   * @param body
   *          the body
   * @param from
   *          the from
   * @param subject
   *          the subject
   */
  @Async
  public void sendEmail(final String[] to, final String body, final String from,
      final String subject) {

    final MimeMessage message = this.mailSender.createMimeMessage();
    final MimeMessageHelper helper = new MimeMessageHelper(message);
    try {
      helper.setFrom(from);
      helper.setSubject(subject);
      helper.setTo(to);
      helper.setText(body, true);
      LOG.info("Going to send an email: ");
      this.mailSender.send(message);
      LOG.info("An email has been sent successfully... ");
    } catch (final MailException ex) {
      LOG.error("Error in sending mail ", ex);
    } catch (final MessagingException me) {
      LOG.error("Error in sending mail ", me);
    }
  }
}
