package com.thonglam.tedprojectbackend.serviceimpl;


import com.thonglam.tedprojectbackend.domain.Email;
import com.thonglam.tedprojectbackend.domain.EmailResponse;
import com.thonglam.tedprojectbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;



@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public EmailResponse sendEmail(Email mail) {

        EmailResponse response = new EmailResponse();
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(mail.getTo());
            message.setSubject(mail.getSubject());
            message.setText(mail.getBody());

            emailSender.send(message);

            response.setCode(0);
            response.setMessage("Email send ok!");
        } catch (Exception ex) {
            response.setCode(1);
            response.setMessage("Error sending email: " + ex.getMessage());
        }

        return response;
    }
}
