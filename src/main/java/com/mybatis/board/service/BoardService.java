package com.mybatis.board.service;


import com.mybatis.board.domain.Board;

import java.util.List;

public interface BoardService {
    // 글저장
    void add(Board board);
    // 목록 조회 : 전체
    List<Board> getAllArticles();
    // 목혹 하나 조회
    Board getOneArticle(Long bid);
}
