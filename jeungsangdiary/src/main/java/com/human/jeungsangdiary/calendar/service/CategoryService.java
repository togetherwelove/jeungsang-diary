package com.human.jeungsangdiary.calendar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.calendar.dao.CategoryDAO;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDAO categoryDAO;

    public List<CategoryVO> getCategories() {
        return categoryDAO.getCategories();
    }
}
