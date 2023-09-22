package com.human.jeungsangdiary.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.jeungsangdiary.board.domain.Board;
import com.human.jeungsangdiary.board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	BoardService boardsv;
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList();
		int result = boardsv.getTotalBoard();
		
		// System.out.println("총 목록갯수 : " + resultList.size());
		
		model.addAttribute("list", resultList);
		model.addAttribute("total", result);
		
		return "board/list";
	}
	
	@GetMapping(path="/read", params="unqId")
	public String read(Model model, int unqId) throws Exception {
		
		// System.out.println("글번호 : " + unqId);
		Board result = boardsv.readBoardOne(unqId);
		int upHit = boardsv.incBoardHit(unqId);	// upHit 특별히 사용하지 않아도 됨
		
		model.addAttribute("board", result);
		model.addAttribute("hit", upHit);
		
		return "board/read";
	}
	
	@GetMapping(path="/delete", params="unqId")
	public String delete(int unqId) throws Exception {
	
		int result = boardsv.removeBoard(unqId);
		System.out.println("삭제결과 : " + result);
		return "redirect:/list";
	}
	
	@GetMapping("/write")
	public String writeForm(Model model) throws Exception {
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(Board board) throws Exception {
	
		int result = boardsv.regBoard(board);
		
		return "redirect:/list";
	}
}