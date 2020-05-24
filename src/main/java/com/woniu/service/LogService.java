package com.woniu.service;

import com.woniu.pojo.Log;

import java.util.Date;

public interface LogService {
    boolean saveLog(Log log);

    boolean deleteLog(Long id);

    long deleteLogByTime(Date date);
}
