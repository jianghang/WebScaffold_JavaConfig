package com.sys.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jianghang on 2017/11/24.
 */
@RestController
@RequestMapping("/")
public class HelloWorldRestController {

    private static Logger logger = LogManager.getLogger(HelloWorldRestController.class);

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(String str){
        logger.info(str);
        return str;
    }
}
