package com.woniu.controller;

import com.woniu.pojo.Standard;
import com.woniu.service.StandardService;
import com.woniu.utils.RestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class StandardController {
    @Autowired
    private StandardService standardService;
    @Autowired
    private Environment environment;

    @PostMapping("/standards")
    public RestDto add(@RequestParam("file") MultipartFile file, Standard standard){
        try {
            standardService.add(standard,file);
            return RestDto.OK();
        } catch (Exception e){
            return RestDto.FAIL();
        }
    }

    @GetMapping("/download/{id}")
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
