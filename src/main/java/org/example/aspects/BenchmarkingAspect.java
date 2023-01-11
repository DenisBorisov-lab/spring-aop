package org.example.aspects;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BenchmarkingAspect {
    @SneakyThrows
    @Around("execution(* org.example.service.PersonServiceImpl.findByName (..))")
    public void calculateProgramTiming(ProceedingJoinPoint joinPoint) {
        long time = System.currentTimeMillis();
        joinPoint.proceed();
        System.out.printf("Method was running %s%n", System.currentTimeMillis() - time);
    }
}
