package com.human.jeungsangdiary.calendar.category;

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
