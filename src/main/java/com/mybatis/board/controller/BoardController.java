package com.mybatis.board.controller;

import com.mybatis.board.domain.Board;
import com.mybatis.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 경로 앞단에 /boards 가 붙는 요청은 여기에
@Slf4j
@RequestMapping("/boards") // ("")을 자동으로 붙혀줌
@Controller
@RequiredArgsConstructor // DB에 저장할라고 <- 주입
public class BoardController {

    // DB에 저장할라고
    private final BoardService boardService;

    //게시글 목록
    @GetMapping("/list") // -> /boards/list와 동일함
    public String list() {
        log.info("*********BoardController GET /list");
        return "board/list";
    }

    //게시글 등록 폼 요청
    @GetMapping("/add")
    public String addForm(@ModelAttribute("board")Board board) {
        log.info("*********BoardController GET boards/add");
        return "board/add"; // <- 이 html 파일 보여줘라
    }

    //게시글 등록 폼 처리 <form 에서 post 메서드여서 이쪽으로 >
    @PostMapping("/add")
    public String addPro(Board board) {
        log.info("*********BoardController POST boards/add {}", board);
        // 로직 처리 : DB에 저장 // Service 불러서 저장
        boardService.add(board);
        return "redirect:/boards/list";
    }

}
