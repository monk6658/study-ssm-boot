package com.study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author zxl
 * @date 2020/10/10 11:03
 */
@RestController
public class FileUploadController {


    @PostMapping("/upload")
    public String uploadFile(MultipartFile[] file) throws IOException {

        for (MultipartFile f: file) {
            f.transferTo(new File("/upload" + f.getOriginalFilename()));
        }

        return "ok";

    }


}
