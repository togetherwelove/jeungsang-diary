package com.human.jeungsangdiary.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.calendar.category.CategoryService;
import com.human.jeungsangdiary.calendar.category.CategoryVO;
import com.human.jeungsangdiary.member.MemberService;
import com.human.jeungsangdiary.member.MemberVO;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    MemberService memberService;

    @Autowired
    CategoryService categoryService;

    @GetMapping()
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
}
