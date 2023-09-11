package com.human.jeungsangdiary.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list() {
        return "/board_list";
    }

    @GetMapping("/read")
    public String read() {
        return "/board_read";
    }

    @GetMapping("/update")
    public String update() {
        return "/board_update";
    }

     @GetMapping("/insert")
    public String insert() {
        return "/board_insert";
    }

}

