package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import com.mybatis.board.dto.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);
    // 레코드 한개는 Board에 담으면 딘다. 레코드가 여러개일 가능성이 있으니 List에 Board들을 담아 리턴받기
    List<Board> selectAll();
    // 글 목록 조회 + 페이징 //XML에 전달하는 매개변수가 2개 이상일 경우는 @Param 어노테이션으로 xml에서 사용할 이름을 부여
    List<Board> selectArticlesWithPaging(@Param("offset") int offset,@Param("size") int size);

    // 글 한개 수정
    Board findOne(Long bid);

    // 글 목록 개수 조회
    Long getArticleCount();

    // 글 카운트
    void updateViewCount(Long bid);

    // 글수정
    int update(Board board);

    // 글삭제
    int delete(Long bid);

}
