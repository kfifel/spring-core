package com.springcore.aspect;

public class LoggingAspect {

    public void beforeAdvice() {
        System.out.println("Before advice");
    }

    public void afterAdvice() {
        System.out.println("After advice");
    }
}
