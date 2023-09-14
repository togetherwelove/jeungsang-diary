package com.human.jeungsangdiary.calendar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.human.jeungsangdiary.calendar.vo.CellVO;

@Mapper
public interface CellMapper {
    List<CellVO> getEvents();
    
    CellVO getEventById(Long cellId);

    void addEvent(CellVO cell);

    Long getLastInsertId();

    void deleteById(Long id);

    Long getNextId();

    void moveEvent(@Param("id") Long id,@Param("postDate") String postDate);

    void updateEvent(CellVO existingCell);

}
