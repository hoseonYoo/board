package com.mybatis.board.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@ToString
public class PageDTO {

    private Long totalArticle;  // 글 전체 개수
    private int totalPage;    // 전체 페이지 수
    private int startPage;    // 화면상 첫페이지 번호
    private int endPage;      // 화면상 마지막페이지 번호
    private boolean prev, next;   // 이전, 다음 페이지 존재 여부
    private Pager pager;          // page, boardSize(페이지에 보여줄 글의 갯수), pagingSize
    private List<Integer> pageList;   // 페이지번호 뿌릴 것 미리 리스트에 담기

    public PageDTO(Pager pager, Long totalArticle){
        this.pager = pager; this.totalArticle = totalArticle;

        // 1 - 10 1p = 10 2p = 10  /pagingSize = 0.1 ~ 1 올림 -> 1 * pagingSize
        // 1 - 10 1p = 10 2p = 10  /pagingSize = 0.1 ~ 1 올림 -> 1 * pagingSize
        // 1 - 10 1p = 10 2p = 10  /pagingSize = 0.1 ~ 1 올림 -> 1 * pagingSize
        this.endPage = (int)Math.ceil((double)pager.getPage() / pager.getPagingSize())*pager.getPagingSize();
        this.startPage = endPage - (pager.getPagingSize() -1);

        this.totalPage = (int)Math.ceil((double)this.totalArticle / pager.getBoardSize());
        if(this.totalPage < this.endPage) { // endpage 조정
            this.endPage = this.totalPage;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage < totalPage;

//        for(int i = startPage; i < endPage; i++) {
//            this.pageList.add(i);
//        }

        this.pageList = IntStream.rangeClosed(startPage, endPage).boxed().collect(Collectors.toList());

        System.out.println("-----------------------------");
        System.out.println("pager = " + pager);
        System.out.println("totalArticle = " + totalArticle);
        System.out.println("startPage = " + startPage);
        System.out.println("endPage = " + endPage);
        System.out.println("totalPage = " + totalPage);
        System.out.println("prev = " + prev);
        System.out.println("next = " + next);
        System.out.println("pageList = " + pageList);
        System.out.println("-----------------------------");

    }
}
