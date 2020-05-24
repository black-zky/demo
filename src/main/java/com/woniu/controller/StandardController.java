package com.woniu.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.aspect.SysLog;
import com.woniu.pojo.Standard;
import com.woniu.service.StandardService;
import com.woniu.utils.RestDto;
import com.woniu.vo.StandardVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
public class StandardController {
    @Autowired
    private StandardService standardService;
    @Autowired
    private Environment environment;

    @GetMapping("/standards")
    @SysLog("查询标准信息")
    public RestDto list(@RequestParam(value = "currentPage", defaultValue="1", required = false) int currentPage,
                        @RequestParam(value = "pageSize", defaultValue="10", required = false) int pageSize,
                        StandardVo standardVo){
        try {
            PageInfo pageInfo = standardService.findByPage(currentPage,pageSize,standardVo);
            return RestDto.OK(pageInfo);
        } catch (Exception e){
            return RestDto.FAIL();
        }
    }

    @DeleteMapping("/standards")
    @SysLog("删除标准信息")
    public RestDto delete(@RequestParam("ids") Integer[] ids){
        try {
            standardService.deleteBatch(ids);
            return RestDto.OK();
        } catch (Exception e){
            return RestDto.FAIL();
        }
    }

    @PostMapping("/standards")
    @SysLog("添加标准信息")
    public RestDto add(@RequestParam("file") MultipartFile file, Standard standard){
        try {
            standardService.add(standard,file);
            return RestDto.OK();
        } catch (Exception e){
            return RestDto.FAIL();
        }
    }

    @GetMapping("/download/{id}")
    @SysLog("下载标准信息文件")
    public ResponseEntity download(@PathVariable("id") Integer id){
        Standard standard = standardService.findById(id);
        if(standard==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        String filename = standard.getPackagepath();
        String path = environment.getProperty("file.upload.url");
        try {
            InputStream input = new FileInputStream(path+File.separator+filename);
            byte[] bytes = new byte[input.available()];
            input.read(bytes);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentDispositionFormData("attachement", filename);
            return new ResponseEntity(bytes, httpHeaders, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
