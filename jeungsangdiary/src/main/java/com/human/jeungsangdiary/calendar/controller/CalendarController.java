package com.human.jeungsangdiary.calendar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.human.jeungsangdiary.calendar.service.CategoryService;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final CategoryService categoryService;

    @GetMapping(value="/calendar")
    public String calendar(Model model) {
        List<CategoryVO> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "calendar/calendar";
    }
}

