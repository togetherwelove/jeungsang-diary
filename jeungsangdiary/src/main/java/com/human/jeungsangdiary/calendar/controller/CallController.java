package com.human.jeungsangdiary.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.human.jeungsangdiary.calendar.service.CellService;
import com.human.jeungsangdiary.calendar.vo.CellVO;

@RestController
public class CallController {

    @Autowired
    CellService cellService;

    @GetMapping("/calendar/event/{id}")
    public CellVO getEvent(@PathVariable("id") Long id) {
    return cellService.getEventById(id);
    }
}
