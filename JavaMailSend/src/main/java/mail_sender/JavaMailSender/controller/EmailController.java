package mail_sender.JavaMailSender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
