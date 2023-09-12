package com.human.jeungsangdiary.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/insert")
    public String insert() {
        return "board/insert";
    }
    
    @PostMapping("/result")
    public String result(HttpServletRequest req, Model model) {

		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		model.addAttribute("memtitle", title);
		model.addAttribute("memwriter", writer);
		model.addAttribute("memcontent", content);
		
		// 폼에서 가져온 데이터를 화면에 출력
		return "board/result";
	}
}
