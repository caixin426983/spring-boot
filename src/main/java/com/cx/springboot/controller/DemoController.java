package com.cx.springboot.controller;

import com.cx.springboot.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @RequestMapping(value = "testCache/{key}",method = RequestMethod.GET)
    public String testCache(@PathVariable String key){
       return demoService.testCache(key);
    }




    @RequestMapping(value = "getSesession")
    @ResponseBody
    public Object getSession(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message",request.getRequestURI());
        map.put("message",request.getRequestURI());
        System.out.println("sessionId"+ request.getSession().getId());
        return map;
    }
}
