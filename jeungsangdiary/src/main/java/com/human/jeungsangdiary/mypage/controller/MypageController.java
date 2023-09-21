package com.human.jeungsangdiary.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
    
    @GetMapping(value="/graph")
    public String graph() {
        return "mypage/graph";
    }
}
