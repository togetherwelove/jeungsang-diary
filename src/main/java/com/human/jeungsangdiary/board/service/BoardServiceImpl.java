package com.human.jeungsangdiary.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.board.entity.BoardEntity;
import com.human.jeungsangdiary.board.mapper.BoardMapper;
import com.human.jeungsangdiary.board.repository.BoardRepository;
import com.human.jeungsangdiary.board.vo.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardmapper;
	
	@Override
	public List<Board> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		List<Board> list = boardmapper.selectBoardList();
		
		return list;
	}

	@Override
	public int getTotalBoard() throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.selectTotalBoard();
		
		return rst;
	}
	
	@Override
	public Board readBoardOne(int no) throws Exception {
		// TODO Auto-generated method stub
		Board rst = boardmapper.selectBoardOne(no);
		
		return rst;
	}
	
	@Override
	public List<Board> insertBoard() throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertBoard'");
	}
	
	private final BoardRepository boardRepository;
	
	
	@Override
	public void save(Board board) {
		// TODO Auto-generated method stub
		BoardEntity boardEntity = BoardEntity.toSaveEntity(board);
        boardRepository.save(boardEntity);
	}

	@Override
	public int incBoardHit(int no) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.updateBoardHit(no);
		
		return rst;
	}
	
	
	// @Override
	// public List<Board> findAll() {
	// 	// TODO Auto-generated method stub
	// 	List<BoardEntity> boardEntityList = boardRepository.findAll();
	// 	List<Board> boardList = new ArrayList<>();
	
	// 	for(BoardEntity boardEntity: boardEntityList) {
	// 			boardList.add(Board.toBoard(boardEntity));
	// 		}
	// 		return boardList;
	// 	}

}
