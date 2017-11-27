package com.sys.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jianghang on 2017/11/23.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    private static Logger logger = LogManager.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String sayHello(ModelMap modelMap){
        modelMap.addAttribute("greeting","Hello World from Spring 4 MVC");
        logger.info(JSONUtils.toJSONString(modelMap));

        return "hello";
    }
}
