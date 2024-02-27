package com.mybatis.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 경로 앞단에 /boards 가 붙는 요청은 여기에
@Slf4j
@RequestMapping("/boards") // ("")을 자동으로 붙혀줌
@Controller
public class BoardController {
    //게시글 목록
    @GetMapping("/list") // -> /boards/list와 동일함
    public String list() {
        log.info("*********BoardController GET /list");
        return "board/list";
    }

    //게시글 등록 폼 요청
    @GetMapping("/add")
    public String addForm() {
        log.info("*********BoardController GET boards/add");
        return "board/add";
    }

    //게시글 등록 폼 처리
    @PostMapping("/add")
    public String addPro() {
        log.info("*********BoardController POST boards/add");
        return "redirect:/boards/list";
    }

}
