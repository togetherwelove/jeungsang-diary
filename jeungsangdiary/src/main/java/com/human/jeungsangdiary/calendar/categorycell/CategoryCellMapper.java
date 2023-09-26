package com.human.jeungsangdiary.calendar.categorycell;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryCellMapper {
  void setCategoryByEventId(
    @Param("categoryId") Long categoryId,
    @Param("insertedEventId") Long insertedEventId
  );
}
