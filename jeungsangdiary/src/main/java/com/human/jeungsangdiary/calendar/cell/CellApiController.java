package com.human.jeungsangdiary.calendar.cell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CellApiController {

    @Autowired
    CellService cellService;

    @GetMapping("/calendar/event/{id}")
    public CellVO getEvent(@PathVariable("id") Long id) {
    return cellService.getEventById(id);
    }
}
