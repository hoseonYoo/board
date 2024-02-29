package com.mybatis.board.dto;

import lombok.Data;

@Data
public class Pager {
    private int page;       // 현재 페이지 번호
    private int boardSize;  // 한 페이지당 보여줄 글의 개수
    private int pagingSize; // 페이지번호 몇개씩 보여줄지 그 개수

    public Paper() {
        // 디폴트 값 설정
        this(1,10,10);
    }
    public Pager(int page, int boardSize, int pagingSize){
        this.page = page; this.boardSize = boardSize; this.pagingSize = pagingSize;
    }
}
