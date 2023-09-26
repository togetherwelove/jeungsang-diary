package com.human.jeungsangdiary.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.human.jeungsangdiary.board.domain.Board;
import com.human.jeungsangdiary.board.domain.Files;
import com.human.jeungsangdiary.board.mapper.BoardMapper;
import com.human.jeungsangdiary.board.mapper.FilesMapper;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardmapper;

	@Autowired
	FilesMapper filesmapper;
	
	@Override
	public List<Board> getBoardList(int page) throws Exception {
		// TODO Auto-generated method stub
		List<Board> list = boardmapper.selectBoardList(page);
		
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
		int rst = boardmapper.insertBoard(board);

		if (rst == 0)
			return rst;

		// 파일 업로드 
		MultipartFile[] files = board.getFiles();

		for( MultipartFile file : files ) {
		 
			if(file.getSize() > 0) {
		 
				byte[] fileData = file.getBytes(); // 첨부파일 데이터
		 
				// 오리지널 파일명 
				String originFileName = file.getOriginalFilename();
				 
				// 새로운 파일명으로 저장 : 날짜_파일명으로 새파일 생성 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
				long currentTime = System.currentTimeMillis(); 
				String newFileName = sdf.format(new Date(currentTime)) + "_" + originFileName;
		
				// 파일업로드 
				File uploadFile = new File(newFileName);
				FileCopyUtils.copy(fileData, uploadFile); 
				
				// bo_notice_file 테이블에 파일 정보를 저장
				Files upfiles = new Files();
				upfiles.setORIGINAL_NAME(originFileName);
				upfiles.setSTORED_NAME(newFileName);
							
				filesmapper.insertFiles(upfiles);
		
			}
		}
		return rst;
	}

	@Override
	public Files getFilesList(int boardId) throws Exception {
		// TODO Auto-generated method stub
		Files downFiles = filesmapper.selectFilesList(boardId);
		
		return downFiles;
	}

}