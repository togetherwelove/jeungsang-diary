package com.human.jeungsangdiary.calendar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryCellMapper {
    void setCategoryByEventId(@Param("categoryId") Long categoryId, @Param("insertedEventId") Long insertedEventId);
}
