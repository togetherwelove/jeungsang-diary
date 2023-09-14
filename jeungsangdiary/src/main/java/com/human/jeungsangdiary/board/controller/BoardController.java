package com.human.jeungsangdiary.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
		String fileName = req.getParameter("file");
		
		model.addAttribute("memtitle", title);
		model.addAttribute("memwriter", writer);
		model.addAttribute("memcontent", content);
		model.addAttribute("filename", fileName);
		
		// 폼에서 가져온 데이터를 화면에 출력
		return "board/result";
	}
    public String result(@RequestParam("file") MultipartFile file, HttpServletRequest req2, Model model) {
    // 기존의 폼 데이터 처리 코드
    
        if (!file.isEmpty()) {
            // 파일이 선택되었을 경우에만 실행되는 로직
            try {
                byte[] fileBytes = file.getBytes();
                String fileName = file.getOriginalFilename();
                // 파일 데이터를 원하는 방식으로 처리
                
                model.addAttribute("memfile", fileBytes);
                model.addAttribute("filename", fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "board/result";
    }
}

