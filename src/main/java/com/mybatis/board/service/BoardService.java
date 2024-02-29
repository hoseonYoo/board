package com.mybatis.board.service;


import com.mybatis.board.domain.Board;
import com.mybatis.board.dto.Pager;

import java.util.List;

public interface BoardService {
    // 글저장
    void add(Board board);
    // 목록 조회 : 전체
    List<Board> getAllArticles();
    // 글 목록 조회
    List<Board> getAllArticlesWithPaging(Pager pager);

    Long getArticleCount();
    // 목혹 하나 조회
    Board getOneArticle(Long bid);
    // 글 수정
    boolean modifyArticle(Board board);
    // 글 삭제
    void removeArticle(Long bid);
}
