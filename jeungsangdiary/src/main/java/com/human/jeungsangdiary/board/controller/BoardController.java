package com.human.jeungsangdiary.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.jeungsangdiary.board.service.BoardService;
import com.human.jeungsangdiary.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/insert")
    public String insert() {
        return "board/insert";
    }

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

    @PostMapping("/list")
    public String list(@ModelAttribute BoardVO boardVO) {
        System.out.println("boardVO = " + boardVO);
        boardService.save(boardVO);

        return "board/list";
    }
}

