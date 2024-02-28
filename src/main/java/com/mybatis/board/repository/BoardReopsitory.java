package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;

public interface BoardReopsitory {
    //게시글 저장
    void save(Board board);
}
