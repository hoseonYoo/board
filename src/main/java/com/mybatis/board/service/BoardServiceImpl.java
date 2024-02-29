package com.mybatis.board.service;

import com.mybatis.board.domain.Board;
import com.mybatis.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor //<- boardrepository 일시킬라면 이걸로 해줘야함
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository; // <- 여기다 일시킬라고 불러서 박아둠

    @Override
    public void add(Board board) {
        log.info("BoardService -- add");
        // Repository 호출해서 DB에 저장 처리 명령
        boardRepository.save(board);
    }

    @Override
    public List<Board> getAllArticles() {
        // 게시글 전체 컨트롤러에게 리턴
        List<Board> list = boardRepository.findAllArticles();
        return list;
    }

    @Override
    public Board getOneArticle(Long bid) {
        // DB에서 가져와서 컨트럴러에 리넡ㄴ
        Board board = boardRepository.findOneArticle(bid);
        return board;
    }

    @Override
    public boolean modifyArticle(Board board) {
        log.info("**** BoardService modifyArticle");
        boolean result = boardRepository.updateArticle(board);
        return result;
    }

    @Override
    public void removeArticle(Long bid) {
        boardRepository.deleteArticle(bid);
    }
}

