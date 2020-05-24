package com.woniu.job;

import com.woniu.pojo.Log;
import com.woniu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class LogScheduler {
    @Value("10")
    private Integer days;

    @Autowired
    private LogService logService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void clearLOg(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        long start = System.currentTimeMillis();
        long count = logService.deleteLogByTime(calendar.getTime());
        long end = System.currentTimeMillis();

        Log log = new Log();
        log.setUsername("系统定时删除日志");
        log.setTime(end-start);
        log.setMethod("");
        log.setParams("");
        log.setCreateDate(new Date());
        log.setIp("");
        log.setOperation("清理了["+count+"]条日志");
        logService.saveLog(log);
    }
}
