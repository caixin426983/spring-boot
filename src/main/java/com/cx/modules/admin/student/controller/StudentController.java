package com.cx.modules.admin.student.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@Api(value = "studentController",description = "用于演示的controller")
public class StudentController {

    @ApiOperation(value = "向指定用户,say hello", notes = "注意问题")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
    @RequestMapping("index")
    public String index(String name){
        return "index";
    }


}
