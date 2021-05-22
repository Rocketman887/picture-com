package ru.itis.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LoggingServiceAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * ru.itis.springbootdemo.services.implementations.*.*(..))")
    public void callService() {
    }

    @Before("callService()")
    public void beforeCall(JoinPoint jp) {
        logger.info("Before call:  " + jp.getSignature()+ "; Arguments:  " + Arrays.toString(jp.getArgs()) +"; time: " + new Date());
    }

    @After("callService()")
    public void afterCall(JoinPoint jp) {
        logger.info("After call:  " + jp.getSignature()+ "; Arguments:  " + Arrays.toString(jp.getArgs()) + "; time: " + new Date());
    }
}
