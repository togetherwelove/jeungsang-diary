package com.human.jeungsangdiary.calendar.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryApiController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/image/{id}")
    public  String getCategoryImgUrlByid(@PathVariable("id") Long id) {
        return categoryService.getCategoryImgUrlById(id);
    }
}
