package com.springcore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.logging.Logger;

public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Before advice" + joinPoint.getSignature().toShortString());
    }

    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("after advice from " + joinPoint.getSignature().toShortString());
    }

    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("result from method " + joinPoint.getSignature().toShortString() + " result:" + result);
    }

    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Exception thrown from method: " + methodName);
        logger.info("Exception message: " + exception.getMessage());
    }

    public Object withinException(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception exception) {
            logger.info("error is thrown"+ exception.getMessage());
        }
        return result;
    }
}
