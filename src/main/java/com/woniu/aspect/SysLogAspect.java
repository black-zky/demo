package com.woniu.aspect;

import com.google.gson.Gson;
import com.woniu.enevt.SpringContextHolder;
import com.woniu.pojo.Log;
import com.woniu.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
public class SysLogAspect {
    @Autowired
    private LogService logService;

    @Around("@annotation(sysLog)")
    public Object saveLog(ProceedingJoinPoint joinPoint, SysLog sysLog){
        long begin = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();

        Log log = new Log();
        log.setUsername("hello");
        log.setOperation(sysLog.value());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.setIp(request.getRemoteHost());
        log.setCreateDate(new Date());
        log.setMethod(joinPoint.getSignature().getName());
        log.setParams(new Gson().toJson(joinPoint.getArgs()));
        log.setTime(end-begin);

        SpringContextHolder.publishEvent(log);
        return obj;
    }
}
