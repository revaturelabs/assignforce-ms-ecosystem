package com.assignforce.locationservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.nozama.nozama.*.*.*(..))")
    public void beforeLog(JoinPoint jp){
        logger.info("    Entering " + jp.getTarget().getClass());
    }
    @After("execution(* com.nozama.nozama.*.*.*(..))")
    public void afterLog(JoinPoint jp){
        logger.info("    Exiting " + jp.getTarget().getClass());
    }

    @AfterThrowing(pointcut="execution(* com.nozama.nozama.*.*.*(..))", throwing="ex")
    public void exceptionAspect(JoinPoint jp, Exception ex) {
        logger.error("    Exception: " + jp.getTarget().getClass() + "  Message: " + ex.getMessage());
    }
}
