package com.human.jeungsangdiary.board.service;

import java.util.List;

import com.human.jeungsangdiary.board.domain.Board;

public interface BoardService {

	// 게시판 목록 가져오기
	public List<Board> getBoardList() throws Exception; 
	
	// 게시글 총 갯수
	public int getTotalBoard() throws Exception;
	
	// 게시글 읽기
	public Board readBoardOne(int unqId) throws Exception;

	// 조회수 업데이트
	public int incBoardHit(int unqId) throws Exception;

	// 게시글 삭제
	public int removeBoard(int unqId) throws Exception;
	
	// 게시글 등록
	public int regBoard(Board board) throws Exception;

}