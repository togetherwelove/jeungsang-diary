package com.human.jeungsangdiary.calendar.mapper;

import com.human.jeungsangdiary.calendar.vo.CategoryVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
  List<CategoryVO> getCategories();

  String getCategoryNameByCellId(Long unqId);

  String getCategoryImgUrlById(Long id);
}
