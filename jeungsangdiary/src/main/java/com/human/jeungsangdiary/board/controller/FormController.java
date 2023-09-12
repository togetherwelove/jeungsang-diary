package com.human.jeungsangdiary.board.controller;

// import java.io.IOException;
// import java.io.InputStream;

// import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.Part;

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
		// 폼에서 넘어온 값을 변수 저장 (로직처리 위해)
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		// Part filePart = req.getPart("file");
    	// String fileName = "";

		// if (filePart != null) {
        // fileName = filePart.getSubmittedFileName(); // 파일 이름 가져오기
        // 파일 처리 로직 작성
        // 예: 서버에 파일 저장, 데이터베이스에 파일 정보 저장 등
        // 이 예시에서는 단순히 파일 이름만 모델에 추가합니다.
        
        // InputStream fileContentStream = filePart.getInputStream();
        // ...
        
        // 필요한 로직 작성
        
        // fileContentStream.close();
    // }
		
		model.addAttribute("memtitle", title);
		model.addAttribute("memwriter", writer);
		model.addAttribute("memcontent", content);
		// model.addAttribute("memfile", fileName);
		
		// 폼에서 가져온 데이터를 화면에 출력
		return "board/result";
	}
}
