package com.human.jeungsangdiary.calendar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.jeungsangdiary.calendar.vo.CategoryVO;


@Mapper
public interface CategoryMapper {
    List<CategoryVO> getCategories();

    String getCategoryName(Long unqId);
}
