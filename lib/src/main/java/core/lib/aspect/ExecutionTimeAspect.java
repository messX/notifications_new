package core.lib.aspect;

import core.lib.annotations.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {
    @Pointcut("within(com.messx.notifications..*) && @annotation(core.lib.annotations.LogExecutionTime)")
    public void logExecutionTimePointCut(){
    }

    @Around("logExecutionTimePointCut()")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Annotation annotation = joinPoint.getClass().getAnnotation(LogExecutionTime.class);
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
