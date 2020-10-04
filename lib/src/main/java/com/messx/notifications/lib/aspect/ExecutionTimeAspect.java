package com.messx.notifications.lib.aspect;

import com.messx.notifications.lib.annotations.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {
    @Pointcut("within(com.messx.notifications..*) && @annotation(com.messx.notifications.lib.annotations.LogExecutionTime)")
    public void logExecutionTimePointCut(){
    }

    @Around("logExecutionTimePointCut()")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = joinPoint.getTarget()
                .getClass()
                .getMethod(signature.getMethod().getName(),
                        signature.getMethod().getParameterTypes());
        Annotation annotation = method.getAnnotation(LogExecutionTime.class);
        LogExecutionTime logExecutionTime = (LogExecutionTime) annotation;
        if(logExecutionTime.enabled()){
            long startTime = System.currentTimeMillis();
            Object object = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Class Name: "+ joinPoint.getSignature().getDeclaringTypeName()
                    +". Method Name: "+ joinPoint.getSignature().getName()
                    + ". Time taken for Execution is : " + timeTaken +"ms");
            return object;
        }
        else{
            return joinPoint.proceed();
        }
    }
}
