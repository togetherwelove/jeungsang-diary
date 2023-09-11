package com.human.jeungsangdiary.calendar.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.jeungsangdiary.calendar.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final CategoryService categoryService;

    @GetMapping(value="/calendar")
    public String calendar(Model model) {
        HashMap<String,String> map = categoryService.getCategories();
        model.addAttribute("categories", map);
        return "/calendar";
    }
}

