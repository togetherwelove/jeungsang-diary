package com.human.jeungsangdiary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.member.MemberService;
import com.human.jeungsangdiary.member.MemberVO;

@Controller
public class HomeController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String home(@SessionAttribute(name = "memberId", required = false) Long id, Model model) {
        if (id != null) {
            MemberVO member = memberService.getLoggedinMember(id);
            model.addAttribute("member", member);
        }
        return "index";
    }


}
