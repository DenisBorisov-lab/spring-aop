package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* org.example.service.PersonServiceImpl.* (..))")
    public void logExecution(JoinPoint joinPoint) {
        System.out.printf("Method call: %s%n", joinPoint.getSignature().getName());
    }

    @After("execution(* org.example.service.PersonServiceImpl.* (..))")
    public void logConclusion(JoinPoint joinPoint) {
        System.out.printf("Method %s was ended!%n", joinPoint.getSignature().getName());
    }

}
