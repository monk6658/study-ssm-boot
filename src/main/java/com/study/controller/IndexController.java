package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zxl
 * @date 2020/10/10 10:52
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }

}
