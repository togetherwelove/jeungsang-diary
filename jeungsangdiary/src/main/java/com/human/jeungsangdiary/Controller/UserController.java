package com.human.jeungsangdiary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.user.UserService;
import com.human.jeungsangdiary.user.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(@SessionAttribute(name = "userId", required = false) Long id) {
        if (id != null) {
            return "redirect:/";
        }
        return "user/login";
    }

    @GetMapping("/join")
    public String join(@SessionAttribute(name = "userId", required = false) Long id) {
        if (id != null) {
            return "redirect:/";
        }
        return "user/join";
    }

    @GetMapping("/detail")
    public String detail(@SessionAttribute(name = "userId") Long id, Model model) {
        if (id == null) {
            return "redirect:/";
        }
        UserVO user = userService.getLoggedinUser(id);
        model.addAttribute("user", user);
        return "user/detail";
    }
}
