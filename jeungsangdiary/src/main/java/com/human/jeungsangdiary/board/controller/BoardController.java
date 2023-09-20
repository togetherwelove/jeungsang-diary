package com.human.jeungsangdiary.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list() {
        return "board/list";
    }

    @GetMapping("/read")
    public String read() {
        return "board/read";
    }

    @GetMapping("/update")
    public String update() {
        return "board/update";
    }

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
        
        return "board/result";
    }
}

