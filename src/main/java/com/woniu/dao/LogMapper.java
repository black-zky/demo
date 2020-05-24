package com.woniu.dao;

import com.woniu.pojo.Log;
import org.apache.ibatis.annotations.Delete;

import java.util.Date;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    @Delete("delete from log where create_date <= #{time}")
    long deleteByTime(Date time);
}