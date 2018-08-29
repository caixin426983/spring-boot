package com.cx.modules.admin.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("s")
public class StudentController {


    @RequestMapping("index")
    public String index(){
        return "index";
    }


}
