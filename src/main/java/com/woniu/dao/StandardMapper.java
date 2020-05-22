package com.woniu.dao;

import com.woniu.pojo.Standard;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}