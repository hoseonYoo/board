package com.mybatis.board.controller;

import com.mybatis.board.domain.Board;
import com.mybatis.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String list(Model model) {
        log.info("*********BoardController GET /list");
        // 게시글 목록 가져와 화면에 전달
        List<Board> list =  boardService.getAllArticles();
        model.addAttribute("list", list);
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
    public String addPro(Board board, RedirectAttributes rttr) {
        log.info("*********BoardController POST boards/add before {}", board);
        // 로직 처리 : DB에 저장 // Service 불러서 저장
        boardService.add(board);
        log.info("*********BoardController POST boards/add after {}", board);
        rttr.addFlashAttribute("bid", board.getBid()); // 리다이렉트되는 list 페이지로 생성된 bid 값 물고옴
        return "redirect:/boards/list";
    }

    //게시글 본문 내용 페이지 요청
    @GetMapping("/{bid}")
    public String detail(@PathVariable("bid") Long bid, Model model) {
        log.info("****boardController get boards/detail - bid {}", bid);
        // 페이지에 보여줄 내용을 DB에서 가져와 view에 전달
        // DB에서 가져오기 위해, PK 인 bid를 이용해 가져오자
        Board board = boardService.getOneArticle(bid);
        log.info("boardController --- getone -- {}", board);
        model.addAttribute("board", board);
        return "board/detail";
    }

    // 글 수정 폼 요청
    @GetMapping("/{bid}/modify")
    public String modifyForm(@PathVariable("bid") Long bid, Model model) {
        log.info("boardController --- modify -- bid -- {}", bid);
        Board board = boardService.getOneArticle(bid);
        log.info("boardController --- modify -- bid -- {}", board);
        model.addAttribute("board", board);
        return "board/modify";
    }

    // 글 수정 처리 요청
    @PostMapping("/{bid}/modify") // @PathVariable("bid")Long bid <- 포스트 맵핑뒤에 있는 주소에서 꺼내는 것
    public String modifyPro(@PathVariable("bid")Long bid, Board board, RedirectAttributes rttr){
        log.info("boardController --- modify -- bid -- {}", bid);
        log.info("boardController --- modify -- board -- {}", board);
        boolean result = boardService.modifyArticle(board);

        if(result){
            rttr.addFlashAttribute("result", board.getBid());
        }
        return "redirect:/boards/{bid}";
    }

    // 글 삭제
    @PostMapping("/{bid}/delete")
    public String delete(@PathVariable("bid")Long bid) {
        log.info("**** BoardController POST/delete -- bid{}", bid);
        boardService.removeArticle(bid);
        return "redirect:/boards/list";
    }

}
