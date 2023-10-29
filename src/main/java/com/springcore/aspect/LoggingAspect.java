package com.springcore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.springcore.service.*.*(..))")
    public void businessService(){}

    @Before("businessService()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Before advice" + joinPoint.getSignature().toShortString());
    }

    @After("businessService()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("after advice from " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(value = "businessService()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("result from method " + joinPoint.getSignature().toShortString() + " result:" + result);
    }

    @AfterThrowing(value = "businessService()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Exception thrown from method: " + methodName);
        logger.info("Exception message: " + exception.getMessage());
    }

    @Around("businessService()")
    public Object withinException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception exception) {
            logger.info("error is thrown"+ exception.getMessage());
        }
        return null;
    }
}
