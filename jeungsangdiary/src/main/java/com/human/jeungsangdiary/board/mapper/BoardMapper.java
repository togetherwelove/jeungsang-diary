package com.human.jeungsangdiary.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.jeungsangdiary.board.vo.Board;

@Mapper
public interface BoardMapper {
    
    public List<Board> selectBoardList() throws Exception;
	
	public int selectTotalBoard() throws Exception;
	
	public Board selectBoardOne(int no) throws Exception;

    public List<Board> insertBoardList() throws Exception;
    
}
