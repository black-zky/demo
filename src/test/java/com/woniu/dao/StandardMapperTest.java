package com.woniu.dao;

import com.woniu.pojo.Standard;
import com.woniu.vo.StandardVo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StandardMapperTest {
    private Logger logger = LoggerFactory.getLogger(StandardMapperTest.class);

    @Autowired
    private StandardMapper standardMapper;

    @Test
    void selectByPage() {
        StandardVo vo = new StandardVo();
        vo.setZhname("玩具");
        Calendar c = Calendar.getInstance();
        c.set(2000,1,1);
        vo.setEnd(c.getTime());
        List<Standard> standards = standardMapper.selectByPage(1,10,vo);
        for (Standard standard: standards){
            logger.info(standard.toString());
        }
    }

    @Test
    void deleteBatch(){
        Integer[] ids = {19,20,21};
        int res = standardMapper.deleteBatch(ids);
        assertTrue(res==ids.length);
    }
}