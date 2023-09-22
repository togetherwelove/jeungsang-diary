package com.human.jeungsangdiary.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.board.domain.Board;
import com.human.jeungsangdiary.board.mapper.BoardMapper;

@Service
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
	public Board readBoardOne(int unqId) throws Exception {
		// TODO Auto-generated method stub
		Board rst = boardmapper.selectBoardOne(unqId);
		
		return rst;
	}

	@Override
	public int incBoardHit(int unqId) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.updateBoardHit(unqId);
		
		return rst;
	}

	@Override
	public int removeBoard(int unqId) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.deleteBoardOne(unqId);
		
		return rst;
	}

	@Override
	public int regBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		int rst = boardmapper.insertBoardList(board);
		
		return rst;
	}
	
}