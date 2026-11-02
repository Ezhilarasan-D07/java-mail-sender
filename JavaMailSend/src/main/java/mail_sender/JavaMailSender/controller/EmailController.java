package mail_sender.JavaMailSender.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController

public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/send-email")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ezhil.13470@gmail.com");
            message.setTo("ezhilarasand07@gmail.com");
            message.setSubject("Sending message using JavaMail Sender");
            message.setText("Hi, darling i have been lost in your eyes.");
            mailSender.send(message);
            return "success";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping("/send-email-with-attachment")
    public String sendEmailWithAttachment() {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("ezhil.13470@gmail.com");
            helper.setTo("ezhilarasand07@gmail.com");
            helper.setSubject("Sending message using JavaMail Sender with attachment");
            helper.setText("Hi, darling i have been lost in your eyes.");

            helper.addAttachment("EzhilProfile.png", new File("F:\\ezhil\\pictures\\formal\\EzhilProfile.png"));
            mailSender.send(message);

            return "success";

        }   catch (Exception e) {
            return e.getMessage();
        }
    }
}
