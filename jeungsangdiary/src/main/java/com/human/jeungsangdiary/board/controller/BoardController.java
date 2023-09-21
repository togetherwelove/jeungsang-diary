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
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardsv;

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList();
		int result = boardsv.getTotalBoard();
		
		model.addAttribute("list", resultList);
		model.addAttribute("total", result);
		
		return "board/list";
	}
	
	@GetMapping(path="/read", params="UNQ_ID")
	public String read(Model model, int UNQ_ID) throws Exception {
		
		Board result = boardsv.readBoardOne(UNQ_ID);
		int upHit = boardsv.incBoardHit(UNQ_ID);
		
		model.addAttribute("board", result);
		model.addAttribute("hit", upHit);
		
		return "board/read";
	}
	
	@GetMapping(path="/delete", params="UNQ_ID")
	public String delete(int UNQ_ID) throws Exception {
	
		int result = boardsv.removeBoard(UNQ_ID);
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

