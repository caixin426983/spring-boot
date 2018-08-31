package com.cx.springboot.controller;


import com.cx.springboot.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@Api(value = "userController")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping("getAllUser")
    public Object getAllUser() {
        return userService.getAllUser();
    }

    @ApiOperation(value = "根据ID查询用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET)
    public Object getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
