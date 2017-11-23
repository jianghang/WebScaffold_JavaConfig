package com.hangjiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jianghang on 2017/11/23.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(ModelMap modelMap){
        modelMap.addAttribute("greeting","Hello World from Spring 4 MVC");

        return "hello";
    }
}
