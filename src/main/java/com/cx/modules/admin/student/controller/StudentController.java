package com.cx.modules.admin.student.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@Api(value = "studentController", description = "用于演示的controller")
public class StudentController {


    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @ApiOperation(value = "向指定用户,say hello", notes = "注意问题")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
    @RequestMapping("index")
    public String index(String name) {
        return "index";
    }


    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "getEntityById/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable int id) {
        logger.info("开始查询某个学生信息");
        return "张珊";
    }

}
