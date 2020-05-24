package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.pojo.Standard;
import com.woniu.vo.StandardVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StandardService {
    Standard findById(Integer id);

    PageInfo findByPage(int currentPage, int pageSize, StandardVo vo);

    boolean deleteBatch(Integer[] ids);

    boolean add(Standard standard, MultipartFile file);
}
