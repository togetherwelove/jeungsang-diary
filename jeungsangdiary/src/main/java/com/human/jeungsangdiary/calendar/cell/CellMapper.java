package com.human.jeungsangdiary.calendar.cell;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CellMapper {
  List<CellVO> getEventsByUnqId(Long unqId);

  CellVO getEventById(Long cellId);

  void addEvent(@Param("cell") CellVO cell, @Param("userId") Long userId);

  void deleteById(Long id);

  Long getNextId();

  void moveEvent(@Param("id") Long id, @Param("postDate") String postDate);

  void updateEvent(CellVO existingCell);
}
