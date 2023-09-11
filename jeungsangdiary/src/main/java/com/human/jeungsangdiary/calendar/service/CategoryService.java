package com.human.jeungsangdiary.calendar.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.calendar.dao.CategoryDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDAO categoryDAO;

    public HashMap<String,String> getCategories() {
        return categoryDAO.getCategories();
    }
}
