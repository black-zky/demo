package com.woniu.service;

import com.woniu.pojo.Standard;
import com.woniu.vo.StandardVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StandardService {
    Standard findById(Integer id);

    List<Standard> findByPage(int currentPage, int pageSize, StandardVo vo);

    boolean deleteBatch(Integer[] ids);

    boolean add(Standard standard, MultipartFile file);
}
