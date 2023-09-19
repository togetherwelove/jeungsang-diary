package com.human.jeungsangdiary.board.service;

import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.board.entity.BoardEntity;
import com.human.jeungsangdiary.board.repository.BoardRepository;
import com.human.jeungsangdiary.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

// VO -> Entity (Entity Class)
// Entity -> VO (VO Class)

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    
    public void save(BoardVO boardVO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardVO);
        boardRepository.save(boardEntity);
    }
   
}
