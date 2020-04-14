package com.atguigu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Value("${spring.mail.username}")
    private String mailFrom;
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("test yiwang");
        message.setText("hahhahahah test yiwang");
        message.setTo("756470059@qq.com");
        message.setFrom(mailFrom);
        mailSender.send(message);
    }

    @Test
    void test02() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setSubject("test yiwang");
            messageHelper.setText("<b>hahhahahah test</b></br> yiwang", true);
            messageHelper.setTo("756470059@qq.com");
            messageHelper.addAttachment("333.jpg", new File("333.jpg"));
            messageHelper.setFrom(mailFrom);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
