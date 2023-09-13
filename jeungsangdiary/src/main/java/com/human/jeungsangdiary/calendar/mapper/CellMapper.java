package com.human.jeungsangdiary.calendar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.human.jeungsangdiary.calendar.vo.CellVO;

@Mapper
public interface CellMapper {
    List<CellVO> getEvents();
}
