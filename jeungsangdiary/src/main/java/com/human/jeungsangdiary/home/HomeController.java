package com.human.jeungsangdiary.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.calendar.category.CategoryService;
import com.human.jeungsangdiary.calendar.category.CategoryVO;
import com.human.jeungsangdiary.member.MemberService;
import com.human.jeungsangdiary.member.MemberVO;

@Controller
public class HomeController {

    @Autowired
    MemberService memberService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(@SessionAttribute(name = "memberId", required = false) Long id, Model model) {
        if (id != null) {
            MemberVO member = memberService.getLoggedinMember(id);
            model.addAttribute("member", member);
        }
        return "index";
    }

    @GetMapping("/calendar")
    public String calendar(@SessionAttribute(name = "memberId", required = false) Long id, Model model) {
        if (id != null) {
            MemberVO member = memberService.getLoggedinMember(id);
            model.addAttribute("member", member);
            List<CategoryVO> categories = categoryService.getCategories();
            model.addAttribute("categories", categories);
            return "calendar/calendar";
        }
        return "user/login";
    }

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

    @GetMapping("/user/detail")
    public String detail(@SessionAttribute(name = "memberId") Long id, Model model) {
        if (id == null) {
            return "redirect:/";
        }
        MemberVO member = memberService.getLoggedinMember(id);
        model.addAttribute("member", member);
        return "user/detail";
    }
}
