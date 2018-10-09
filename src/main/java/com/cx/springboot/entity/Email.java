package com.cx.springboot.entity;

import java.io.Serializable;
import java.util.HashMap;

public class Email implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 2611898039402458333L;

    //==============================================================================================================================
    //============================================================必填参数==========================================================
    //==============================================================================================================================
    /**
     * 接收方邮件
     */
    private String email;
    /**
     * 主题
     */
    private String subject;
    /**
     * 内容
     */
    private String content;

    //==============================================================================================================================
    //============================================================选填参数==========================================================
    //==============================================================================================================================
    /**
     * 模板
     */
    private String template;
    /**
     * 自定义参数
     */
    private HashMap<String,String> map;




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }
}
