package com.mybatis.board.service;

import com.mybatis.board.domain.Board;
import com.mybatis.board.repository.BoardReopsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor //<- boardrepository 일시킬라면 이걸로 해줘야함
public class BoardServiceImpl implements BoardService{

    private final BoardReopsitory boardReopsitory; // <- 여기다 일시킬라고 불러서 박아둠

    @Override
    public void add(Board board) {
        log.info("BoardService -- add");
        // Repository 호출해서 DB에 저장 처리 명령
        boardReopsitory.save(board);
    }
}

