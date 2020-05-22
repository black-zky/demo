package com.woniu.dao;

import com.woniu.pojo.Standard;
import com.woniu.vo.StandardVo;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);

    Standard selectByPage(int currentPage, int pageSize,@Param("vo") StandardVo vo);
}
