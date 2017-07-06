/*
 * 文件名：HttpAspect.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：xiyan
 * 修改时间：2017年7月6日
 */

package com.neon.apple.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
    
    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.neon.apple.controller.PeopleController.add(..))")
    public void aspect1() {
        
    }
    @Before("aspect1()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        log.info("URL是：{}",request.getRequestURL());
        //Method
        log.info("方法是：{}",request.getMethod());
        //IP
        log.info("Ip是：{}",request.getRemoteAddr());
        //访问的类和方法    
        log.info("访问的类是：{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("访问的方法是：{}",joinPoint.getSignature().getName());
        //参数    
        log.info("参数是：{}",joinPoint.getArgs());
    }
    
    @AfterReturning(pointcut="aspect1()",returning="obj")
    public void name2(Object obj) {
        log.info("返回是：{}",obj);
    }
    
    @After("aspect1()")
    public void name1() {
        System.out.println("after方法执行.....");

    }
    
}
