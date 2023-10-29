package com.springcore.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectHelper {

    // Define a pointcut that matches all methods within the com.springcore.service package
    // All methods in all class in service packagen that take any parameter and return any type
    @Pointcut("execution(* com.springcore.service.*.*(..))")
    public void allServices() {}

    // Define a pointcut that matches methods starting with "get" within any package
    @Pointcut("execution(* com.*.*.get*(..))")
    public void allMethodStartWithGet() {}

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod(){}

    //The execution of any method with a name that begins with set:

    @Pointcut("execution(* set*(..))")
    public void allStartWithSet(){}

    //The execution of any method defined in the service package:
    @Pointcut("execution(* com.springcore.service.*.*(..))")
    public void AllMethodsInsideServicePackage() {}
}
