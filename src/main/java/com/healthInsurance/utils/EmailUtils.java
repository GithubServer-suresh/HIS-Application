package com.healthInsurance.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.healthInsurance.model.RegisterInfo;

@Component
public class EmailUtils {

	@Autowired
    private JavaMailSender javaMailSender;
	
	
	public boolean sendUserAccUnlockEmail(RegisterInfo info)  {
		boolean isSent = false;
		try {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);		
			helper.setTo(info.getEmail());
			helper.setSubject("Unlock your account");
			helper.setText(getUnlockAccEmailBody(info), true);
		
			javaMailSender.send(msg);
			
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSent;
	}
	
	private String getUnlockAccEmailBody(RegisterInfo registerInfo) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", registerInfo.getFirstName());
		mailBody = mailBody.replace("{LNAME}", registerInfo.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}",registerInfo.getPassword());
		mailBody = mailBody.replace("{EMAIL}", registerInfo.getEmail());

		return mailBody;
	}
	
	
	
	
	//Sending Password to email 
	
	public boolean sendPasswordToEmail(RegisterInfo user)  {
		boolean isSent = false;
		try {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);		
			helper.setTo(user.getEmail());
			helper.setSubject("Account Password");
			helper.setText(getPwdByEmailBody(user), true);
		
			javaMailSender.send(msg);
			
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSent;
	}
	
	private String getPwdByEmailBody(RegisterInfo userInfo) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("ACCOUNT-PASSWORD.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{AccFNAME}", userInfo.getFirstName());
		mailBody = mailBody.replace("{AccLNAME}", userInfo.getLastName());
		mailBody = mailBody.replace("{AccPassword}",userInfo.getPassword());
		mailBody = mailBody.replace("{AccEMAIL}", userInfo.getEmail());

		return mailBody;
	}
	
	
	


/*	public boolean sendEmail(String to, String subject,String body) {
		
        try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			javaMailSender.send(msg);
			return true;
		} catch (MailException e) {
			e.printStackTrace();
		}
        return false;
	}
	
public boolean sendEmailWithAttachment(String to, String subject,String body) throws MessagingException {
		
        try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);		
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			javaMailSender.send(msg);
			return true;
		} catch (MailException e) {
			e.printStackTrace();
		}
        return false;
	}
    */
}
