package com.woniu.service.impl;

import com.woniu.dao.LogMapper;
import com.woniu.pojo.Log;
import com.woniu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public boolean saveLog(Log log) {
        logMapper.insert(log);
        return true;
    }

    @Override
    public boolean deleteLog(Long id) {
        logMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public long deleteLogByTime(Date date) {
        return logMapper.deleteByTime(date);
    }
}
