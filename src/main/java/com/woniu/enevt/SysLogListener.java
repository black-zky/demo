package com.woniu.enevt;

import com.woniu.pojo.Log;
import com.woniu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync //启用异步注解
public class SysLogListener {
    @Autowired
    private LogService logService;

    @Async
    @EventListener
    public void saveLog(SysLogEvent sysLogEvent){
        Log log = (Log) sysLogEvent.getSource();
        logService.saveLog(log);
    }
}
