package com.mybatis.board.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long bid;
    private String title;
    private String writer;
    private String content;
    private Integer count;
    private LocalDateTime createDate;
}
