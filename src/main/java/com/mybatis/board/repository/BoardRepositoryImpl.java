package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardReopsitory{

    private final BoardMapper boardMapper;

    @Override
    public void save(Board board) {
        // Mapper에게 저장하는 sql문 실행하라고 명령
        log.info("boardRepository -- save Before : {}", board);
        boardMapper.insert(board);
        log.info("boardRepository -- save After : {}", board);
    }
}
