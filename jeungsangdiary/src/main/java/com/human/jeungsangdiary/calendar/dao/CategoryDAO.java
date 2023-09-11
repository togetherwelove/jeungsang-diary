package com.human.jeungsangdiary.calendar.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.human.jeungsangdiary.calendar.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryDAO {

    private final CategoryMapper categoryMapper;
    
    public HashMap<String, String> getCategories() {
        return categoryMapper.getCategories();
    }
}
