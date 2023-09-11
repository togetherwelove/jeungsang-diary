package com.human.jeungsangdiary.calendar.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.human.jeungsangdiary.calendar.mapper.CategoryMapper;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryDAO {

    private final CategoryMapper categoryMapper;
    
    public List<CategoryVO> getCategories() {
        return categoryMapper.getCategories();
    }
}
