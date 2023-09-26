package com.human.jeungsangdiary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.member.MemberService;
import com.human.jeungsangdiary.member.MemberVO;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String login(@SessionAttribute(name = "memberId", required = false) Long id) {
        if (id != null) {
            return "redirect:/";
        }
        return "user/login";
    }

    @GetMapping("/join")
    public String join(@SessionAttribute(name = "memberId", required = false) Long id) {
        if (id != null) {
            return "redirect:/";
        }
        return "user/join";
    }

    @GetMapping("/detail")
    public String detail(@SessionAttribute(name = "memberId") Long id, Model model) {
        if (id == null) {
            return "redirect:/";
        }
        MemberVO member = memberService.getLoggedinMember(id);
        model.addAttribute("member", member);
        return "user/detail";
    }
}
