package com.human.jeungsangdiary.calendar.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CategoryMapper {
    HashMap<String, String> getCategories();
}
