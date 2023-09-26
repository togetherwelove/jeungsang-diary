package com.human.jeungsangdiary.calendar.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  CategoryDAO categoryDAO;

  public List<CategoryVO> getCategories() {
    return categoryDAO.getCategories();
  }

  public String getCategoryImgUrlById(Long id) {
    return categoryDAO.getCategoryImgUrlByid(id);
  }
}
