package com.human.jeungsangdiary.board.service;

import java.util.List;

import com.human.jeungsangdiary.board.domain.Board;
import com.human.jeungsangdiary.board.domain.Files;

public interface BoardService {

	// 게시판 목록 가져오기
	public List<Board> getBoardList(int page) throws Exception; 
	
	// 게시글 총 갯수
	public int getTotalBoard() throws Exception;
	
	// 게시글 읽기
	public Board readBoardOne(int unqId) throws Exception;

	// 첨부파일 목록 가져오기
	public Files getFilesList(int boardid) throws Exception;

	// 조회수 업데이트
	public int incBoardHit(int unqId) throws Exception;

	// 게시글 삭제
	public int removeBoard(int unqId) throws Exception;
	
	// 게시글 등록
	public int regBoard(Board board) throws Exception;

}