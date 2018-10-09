package com.cx.springboot.controller;


import com.cx.springboot.entity.Email;
import com.cx.springboot.util.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
@Api(value = "emailController")
public class EmailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "testSend" ,method = RequestMethod.GET)
    public void testSend(){
        Email email = new Email();
        email.setEmail("1017629364@qq.com");
        email.setSubject("起来嗨!!!");
        email.setContent("麻将约起了？？？    欠我的钱什么时候还！！！！");
        mailService.send(email);
    }


}
