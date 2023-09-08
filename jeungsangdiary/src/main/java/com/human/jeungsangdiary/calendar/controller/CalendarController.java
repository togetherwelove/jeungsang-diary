package com.human.jeungsangdiary.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
    @GetMapping(value="/calendar")
    public String calendar() {
        return "/calendar";
    }
}

