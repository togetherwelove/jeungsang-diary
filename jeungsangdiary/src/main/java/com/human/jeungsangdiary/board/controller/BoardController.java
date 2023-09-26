package com.human.jeungsangdiary.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.human.jeungsangdiary.board.domain.Board;
import com.human.jeungsangdiary.board.domain.Files;
import com.human.jeungsangdiary.board.domain.Page;
import com.human.jeungsangdiary.board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	BoardService boardsv;
	
	@GetMapping(path="/list", params="page")
	public String list(Model model, int page) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList(page);
		int result = boardsv.getTotalBoard();
		
		Page pageObj = new Page();		// 기본값 설정됨(Page.java)
		pageObj.setTotalCount(result);	// 전체 갯수 설정
		pageObj.paging();				// 변수 계산 처리
		
		model.addAttribute("list", resultList);
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("page", page);
		
		return "board/list";
	}
	
	@GetMapping(path="/detail", params="unqId")
	public String read(Model model, int unqId) throws Exception {
		
		Board result = boardsv.readBoardOne(unqId);

		int boardid = unqId;
		Files downFiles = boardsv.getFilesList(boardid);

		int upHit = boardsv.incBoardHit(unqId);
		
		model.addAttribute("board", result);
		model.addAttribute("hit", upHit);
		model.addAttribute("down", downFiles);

		return "board/detail";
	}
	
	@GetMapping(path="/delete", params="unqId")
	public String delete(int unqId) throws Exception {
	
		int result = boardsv.removeBoard(unqId);
		System.out.println("삭제결과 : " + result);
		return "redirect:/board/list?page=1";
	}
	
	@GetMapping("/insert")
	public String writeForm(Model model) throws Exception {
		
		return "board/insert";
	}
	
	@PostMapping("/insert")
	public String insert(Board board) throws Exception {

		MultipartFile[] files = board.getFiles();

		if(files != null) {
			
			for(MultipartFile file : files) {
				
				System.out.println("파일명 : " + file.getOriginalFilename());
			}
		}
	
		int result = boardsv.regBoard(board);
		
		return "redirect:/board/list?page=1";
	}

}