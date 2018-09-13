package com.cx.springboot.controller;


import com.cx.springboot.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@Api(value = "userController")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "getAllUser",method = RequestMethod.GET)
    public Object getAllUser() {
        return userService.getAllUser();
    }

    @ApiOperation(value = "根据ID查询用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long")
    @RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET)
    public Object getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    /**
     *  测试swagger2 Get请求时,路径传入多个参数
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, paramType = "path", dataType = "int")
    })
    public Object page(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return userService.page(pageNum, pageSize);
    }



}
