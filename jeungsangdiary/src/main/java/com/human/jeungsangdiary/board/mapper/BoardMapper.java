package com.human.jeungsangdiary.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.jeungsangdiary.board.domain.Board;

@Mapper
public interface BoardMapper {
    
    public List<Board> selectBoardList(int page) throws Exception;
	
	public int selectTotalBoard() throws Exception;
	
	public Board selectBoardOne(int unqId) throws Exception;

    public int updateBoardHit(int unqId) throws Exception;
	
	public int deleteBoardOne(int unqId) throws Exception;
	
	public int insertBoard(Board board) throws Exception;
    
}