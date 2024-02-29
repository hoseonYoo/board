package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);
    // 레코드 한개는 Board에 담으면 딘다. 레코드가 여러개일 가능성이 있으니 List에 Board들을 담아 리턴받기
    List<Board> selectAll();

    // 글 한개 수정
    Board findOne(Long bid);

    // 글수정
    int update(Board board);

    // 글삭제
    int delete(Long bid);

}
