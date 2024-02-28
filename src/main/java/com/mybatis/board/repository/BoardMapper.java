package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);
    // 레코드 한개는 Board에 담으면 딘다. 레코드가 여러개일 가능성이 있으니 List에 Board들을 담아 리턴받기
    List<Board> selectAll();

    Board findOne(Long bid);

}
