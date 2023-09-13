package com.human.jeungsangdiary.calendar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.jeungsangdiary.calendar.service.CategoryService;
import com.human.jeungsangdiary.calendar.service.CellService;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;


@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CellService cellService;

    @RequestMapping
    public String calendar(Model model) {
        List<CategoryVO> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "calendar/calendar";
    }

    @GetMapping("/event")
    public @ResponseBody List<Map<String, Object>> getEvent(){
        List<Map<String, Object>> eventList = cellService.getEventList();
        if (eventList == null) {
            eventList = new ArrayList<>();
        }
        return eventList;
    }
}

