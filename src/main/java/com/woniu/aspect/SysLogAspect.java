package com.woniu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SysLogAspect {


    @Around("@annotation(SysLog)")
    public void saveLog(ProceedingJoinPoint joinPoint, SysLog sysLog){

    }
}
