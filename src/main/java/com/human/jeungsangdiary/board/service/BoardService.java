package com.human.jeungsangdiary.board.service;

import java.util.List;

import com.human.jeungsangdiary.board.vo.Board;

public interface BoardService {

	// 게시판 목록 가져오기
	public List<Board> getBoardList() throws Exception; 
	
	// 게시글 총 갯수
	public int getTotalBoard() throws Exception;
	
	// 게시글 읽기
	public Board readBoardOne(int no) throws Exception;
	
	// 게시글 쓰기
	public List<Board> insertBoard() throws Exception;

	// 게시글 저장
	public void save(Board board) throws Exception;

	// 조회수 업데이트
	public int incBoardHit(int no) throws Exception;

	// public List<Board> findAll() throws Exception;
}

