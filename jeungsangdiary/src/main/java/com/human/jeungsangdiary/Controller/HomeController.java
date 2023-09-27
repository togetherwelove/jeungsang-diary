package com.human.jeungsangdiary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.user.UserService;
import com.human.jeungsangdiary.user.UserVO;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(@SessionAttribute(name = "userId", required = false) Long id, Model model) {
        if (id != null) {
            UserVO user = userService.getLoggedinUser(id);
            model.addAttribute("user", user);
        }
        return "index";
    }


}
