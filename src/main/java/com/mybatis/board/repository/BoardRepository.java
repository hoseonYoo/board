package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;

import java.util.List;

public interface BoardRepository {
    //게시글 저장
    void save(Board board);
    //게시글 목록
    List<Board> findAllArticles();
    //게시글 한개 조회
    Board findOneArticle(Long bid);
}
