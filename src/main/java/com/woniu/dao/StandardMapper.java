package com.woniu.dao;

import com.woniu.pojo.Standard;
import com.woniu.vo.StandardVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);

    List<Standard> selectByPage(int currentPage, int pageSize, @Param("vo") StandardVo vo);

    int deleteBatch(Integer[] ids);
}
