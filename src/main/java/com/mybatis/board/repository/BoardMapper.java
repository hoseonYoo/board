package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void insert(Board board);

}
