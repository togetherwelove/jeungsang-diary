package com.human.jeungsangdiary.calendar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.jeungsangdiary.calendar.mapper.CategoryMapper;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;

@Repository
public class CategoryDAO {

    @Autowired
    CategoryMapper categoryMapper;
    
    public List<CategoryVO> getCategories() {
        return categoryMapper.getCategories();
    }

    public String selectCategoryName(Long unqId) {
        return categoryMapper.getCategoryName(unqId);
    }
}
