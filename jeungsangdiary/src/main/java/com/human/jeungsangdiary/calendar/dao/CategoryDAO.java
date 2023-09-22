package com.human.jeungsangdiary.calendar.dao;

import com.human.jeungsangdiary.calendar.mapper.CategoryMapper;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

  @Autowired
  CategoryMapper categoryMapper;

  public List<CategoryVO> getCategories() {
    return categoryMapper.getCategories();
  }

  public String getCategoryNameByCellId(Long unqId) {
    return categoryMapper.getCategoryNameByCellId(unqId);
  }

  public String getCategoryImgUrlByid(Long id) {
    return categoryMapper.getCategoryImgUrlById(id);
  }
}
