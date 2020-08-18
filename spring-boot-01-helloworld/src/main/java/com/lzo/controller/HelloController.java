package com.lzo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lzo
 */
@Controller
public class HelloController {
    @ResponseBody
    //接收来自浏览器的hello请求
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
