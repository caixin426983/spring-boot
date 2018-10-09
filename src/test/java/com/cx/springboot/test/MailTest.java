package com.cx.springboot.test;


import com.cx.springboot.Application;
import com.cx.springboot.entity.Email;
import com.cx.springboot.util.MailService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class MailTest {

    @Autowired
    private MailService mailService;


    public void testSend(){
        Email email = new Email();
        email.setEmail("836566274@qq.com");
        email.setSubject("注册验证");
        email.setContent("测试内容");
        mailService.send(email);
    }

}
