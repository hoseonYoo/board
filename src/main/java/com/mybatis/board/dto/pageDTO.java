package com.mybatis.board.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class pageDTO {
    private Long totalArticle;  // 글 전체 개수
    private int totalPage;    // 전체 페이지 수
    private int startPage;    // 화면상 첫페이지 번호
    private int endPage;      // 화면상 마지막페이지 번호
    private boolean prev, next;   // 이전, 다음 페이지 존재 여부
    private Pager pager;
    private List<Integer> pageList;   // 페이지번호 뿌릴 것 미리 리스트에 담기

    public PageDTO(Pager pager, Long totalArticle){
        this.pageer = pager; this.totalArticle = totalArticle;
    }
}
