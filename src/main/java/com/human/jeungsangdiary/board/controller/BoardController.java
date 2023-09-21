package com.human.jeungsangdiary.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.jeungsangdiary.board.service.BoardService;
import com.human.jeungsangdiary.board.vo.Board;


@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardsv;

	@GetMapping("/insert")
	    public String insert() {
	        return "board/insert";
	    }

	@GetMapping("/update")
	    public String update() {
	        return "board/update";
	    }
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		List<Board> resultList = boardsv.getBoardList();
		int result = boardsv.getTotalBoard();
		
		model.addAttribute("list", resultList);
		model.addAttribute("total", result);
		
		return "board/list";
	}
	
	@PostMapping("/list")
	public String list(@ModelAttribute Board board) throws Exception {
	
		boardsv.save(board);
	
		return "redirect:/board/list";
	}

	// @GetMapping("list")
	// public String findAll(Model model) throws Exception {
		
	// 	List<Board> resultList = boardsv.findAll();
	
	// 	model.addAttribute("boardList", resultList);
	
	// 	return "board/list";
	// }

	@GetMapping(path="/read", params="unqId")
	public String read(Model model, int unqId) throws Exception {
		
		Board result = boardsv.readBoardOne(unqId);
		int upHit = boardsv.incBoardHit(unqId);
		
		model.addAttribute("board", result);
		model.addAttribute("hit", upHit);
		
		return "board/read";
	}


}

