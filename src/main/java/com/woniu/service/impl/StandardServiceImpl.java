package com.woniu.service.impl;

import com.woniu.dao.StandardMapper;
import com.woniu.pojo.Standard;
import com.woniu.service.StandardService;
import com.woniu.vo.StandardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    private StandardMapper standardMapper;
    @Autowired
    private Environment environment;

    @Override
    public Standard findById(Integer id) {
        return standardMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Standard> findByPage(int currentPage, int pageSize, StandardVo vo) {
        List<Standard> standards = standardMapper.selectByPage(currentPage,pageSize,vo);
        return null;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        standardMapper.deleteBatch(ids);
        return true;
    }

    @Transactional
    @Override
    public boolean add(Standard standard, MultipartFile file) {
        String path = environment.getProperty("file.upload.url");
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }

        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsss");
        String prefix = sdf.format(new Date());
        filename=prefix+suffix;
        try {
            file.transferTo(new File(path+ File.separator+filename));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件上次失败");
        }

        standard.setPackagepath(filename);
        standardMapper.insert(standard);
        return true;
    }
}
