package com.mybatis.board.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reply {
    private Long rid;
    private Long bid;
    private String reply;
    private String replyer;
    private LocalDateTime replyDate;
}
