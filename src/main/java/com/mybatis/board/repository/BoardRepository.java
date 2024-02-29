package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import com.mybatis.board.dto.Pager;

import java.util.List;

public interface BoardRepository {
    //게시글 저장
    void save(Board board);
    //게시글 목록
    List<Board> findAllArticles();
    //게시글 모두 조회
    List<Board> getAllArticlesWithPaging(Pager pager);
    //게시글 한개 조회
    Board findOneArticle(Long bid);
    //글 전체 개수 조회
    Long getArticleCount();
    // 글 조회수 올리기
    void updateViewCount(Long bid);

    //게시글 수정
    boolean updateArticle(Board board);
    //게시글 삭제
    void deleteArticle(Long bid);
}
