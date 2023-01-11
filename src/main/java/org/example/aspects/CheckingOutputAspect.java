package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckingOutputAspect {
    @AfterReturning(value = "execution(* org.example.service.PersonServiceImpl.findByName(..))",
            returning = "result")
    public void informExceptionIfResultNull(JoinPoint joinPoint, Object result) {
        if (result == null) {
            System.out.printf("Error in method %s%n", joinPoint.getSignature().getName());
            System.out.println("Object hasn't been found in database!");
        } else {
            System.out.println(result);
        }
    }

    @AfterThrowing(value = "execution(* org.example.service.PersonServiceImpl.getAverageSalary(..))",
            throwing = "error")
    public void catchNPEIfPersonIsNull(JoinPoint joinPoint, Throwable error) {
        System.out.printf("Error in method %s: there is no person with this name%n", joinPoint.getSignature().getName());
    }
}
