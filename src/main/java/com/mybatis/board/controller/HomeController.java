package com.mybatis.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 경로 앞단에 /boards 가 "안"붙는 요청은 여기에
@Slf4j
@Controller
public class HomeController {
    @RequestMapping("/") //...8080
    public String home(){
        log.info("home");
       return "redirect:/boards/list";
    }

    @GetMapping("/testMain")
    public String testMain(){
        return "testMain";
    }
}
