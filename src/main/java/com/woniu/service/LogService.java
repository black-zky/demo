package com.woniu.service;

import com.woniu.pojo.Log;

public interface LogService {
    boolean saveLog(Log log);

    boolean deleteLog(Long id);
}
