package com.human.jeungsangdiary.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.jeungsangdiary.calendar.dao.CategoryDAO;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<CategoryVO> getCategories() {
        return categoryDAO.getCategories();
    }
}
