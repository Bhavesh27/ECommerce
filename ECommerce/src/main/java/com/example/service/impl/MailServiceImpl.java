package com.example.service.impl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.service.MailService;

@Service(value="mailService")
@Transactional
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail (User user) {
		// TODO Auto-generated method stub
		 MimeMessagePreparator preparator = getMessagePreparator(user);
		 
	        try {
	            mailSender.send(preparator);
	            System.out.println("Message Send...Hurrey");
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }
	 
	    private MimeMessagePreparator getMessagePreparator(final User user) {
	 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                mimeMessage.setFrom();
	                mimeMessage.setRecipient(Message.RecipientType.TO,
	                        new InternetAddress(user.getEmail()));
	                mimeMessage.setText("Dear " + user.getUsername()
	                        + ", thank you for registering.\n\n You have Registered Successfully");
	                mimeMessage.setSubject("Welcome to Nerds Ville");
	            }
	        };
	        return preparator;
	}

	
}
