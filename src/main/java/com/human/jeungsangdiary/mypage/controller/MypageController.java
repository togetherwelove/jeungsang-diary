package com.human.jeungsangdiary.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
    
    @GetMapping(value="/graph")
    public String showGraphPage() {
        return "mypage/graph";
    }
}
