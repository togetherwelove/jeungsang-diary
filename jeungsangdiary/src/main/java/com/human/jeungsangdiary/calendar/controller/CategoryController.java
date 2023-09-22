package com.human.jeungsangdiary.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.human.jeungsangdiary.calendar.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/image/{id}")
    public  String getCategoryImgUrlByid(@PathVariable("id") Long id) {
        return categoryService.getCategoryImgUrlById(id);
    }
}
