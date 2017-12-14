package com.sys.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by jianghang on 2017/12/14.
 */
public class ControllerInterceptor  extends HandlerInterceptorAdapter{

    private Logger logger = LogManager.getLogger(ControllerInterceptor.class);

    private final static String REQUEST_UUID = "requestUUID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUUID = ThreadContext.get(REQUEST_UUID);
        if(requestUUID == null || "".equals(requestUUID)){
            String uuid = UUID.randomUUID().toString().toUpperCase();
            uuid = uuid.replaceAll("-","");
            ThreadContext.put(REQUEST_UUID,uuid);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ThreadContext.remove(REQUEST_UUID);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadContext.clearMap();
    }
}
