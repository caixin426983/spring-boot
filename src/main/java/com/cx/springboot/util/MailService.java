package com.cx.springboot.util;

import com.cx.springboot.entity.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 执行者
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送者
     */
    @Value("${spring.mail.username}")
    private String USER_NAME;


    public void send(Email email){
        logger.info("发送邮件");
        MailUtil mailUtil = new MailUtil();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(USER_NAME);
        message.setTo(email.getEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        mailUtil.start(mailSender, message);


    }
}
