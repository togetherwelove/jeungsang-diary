package com.human.jeungsangdiary.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/result")
    public String result() {
        return "board/result";
    }

}

