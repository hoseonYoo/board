package com.mybatis.board.repository;

import com.mybatis.board.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardMapper boardMapper;

    @Override
    public void save(Board board) {
        // Mapper에게 저장하는 sql문 실행하라고 명령
        log.info("boardRepository -- save Before : {}", board);
        boardMapper.insert(board);
        log.info("boardRepository -- save After : {}", board);
    }

    @Override
    public List<Board> findAllArticles() {
        // DB에서 게시글 ㅁ두 가져와 service한테 리턴
        List<Board> list = boardMapper.selectAll();
        return list;
    }

    @Override
    public Board findOneArticle(Long bid) {
        //DB에서 가져와서 Service에 리턴
        Board board = boardMapper.findOne(bid);
        return board;
    }

    @Override
    public boolean updateArticle(Board board) {
        log.info("**** BoardRepository modifyArticle");
        int updateCount = boardMapper.update(board);
        log.info("**** BoardRepository modifyArticle -- result {}", updateCount);
        if(updateCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteArticle(Long bid) {
        int result = boardMapper.delete(bid);
        log.info("****BoardRepository delete -- result : {}", result);
    }


}
