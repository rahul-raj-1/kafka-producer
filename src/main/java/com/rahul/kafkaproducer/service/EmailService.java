/*
 * package com.rahul.kafkaproducer.service;
 * 
 * 
 * import java.io.File;
 * 
 * import javax.mail.Message; import javax.mail.internet.InternetAddress; import
 * javax.mail.internet.MimeMessage;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.io.FileSystemResource; import
 * org.springframework.mail.MailException; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.MimeMessageHelper; import
 * org.springframework.mail.javamail.MimeMessagePreparator; import
 * org.springframework.stereotype.Service;
 * 
 * 
 * 
 * @Service("emailService") public class EmailService {
 * 
 * @Autowired private JavaMailSender mailSender;
 * 
 * @Autowired private SimpleMailMessage preConfiguredMessage;
 * 
 *//**
	 * This method will send compose and send the message
	 *//*
		 * public void sendMail(String to, String subject, String body) {
		 * SimpleMailMessage message = new SimpleMailMessage(); message.setTo(to);
		 * message.setSubject(subject); message.setText(body); mailSender.send(message);
		 * }
		 * 
		 * 
		 * 
		 * public void sendMailWithAttachment(String to, String subject, String body,
		 * String fileToAttach) { MimeMessagePreparator preparator = new
		 * MimeMessagePreparator() { public void prepare(MimeMessage mimeMessage) throws
		 * Exception { mimeMessage.setRecipient(Message.RecipientType.TO, new
		 * InternetAddress(to)); mimeMessage.setFrom(new
		 * InternetAddress("admin@gmail.com")); mimeMessage.setSubject(subject);
		 * mimeMessage.setText(body);
		 * 
		 * FileSystemResource file = new FileSystemResource(new File(fileToAttach));
		 * MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		 * helper.addAttachment("logo.jpg", file); } };
		 * 
		 * try { mailSender.send(preparator); } catch (MailException ex) { // simply log
		 * it and go on... System.err.println(ex.getMessage());
		 * 
		 * } } }
		 */