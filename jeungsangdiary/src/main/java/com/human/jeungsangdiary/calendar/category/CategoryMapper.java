package com.human.jeungsangdiary.calendar.category;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
  List<CategoryVO> getCategories();

  String getCategoryNameByCellId(Long unqId);

  String getCategoryImgUrlById(Long id);
}
