package com.human.jeungsangdiary.calendar.cell;

import com.human.jeungsangdiary.calendar.category.CategoryDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CellService {

  @Autowired
  CellDAO cellDAO;

  @Autowired
  CategoryDAO categoryDAO;

  public List<Map<String, Object>> getEventsByUnqId(Long unqId) {
    List<Map<String, Object>> eventList = new ArrayList<Map<String, Object>>();
    Map<String, Object> event = new HashMap<>();

    List<CellVO> cells = cellDAO.getEventsByUnqId(unqId);

    for (CellVO cell : cells) {
      event = new HashMap<>();
      String category = categoryDAO.getCategoryNameByCellId(cell.getUnqId());
      String start = cell.getPostDate();
      event.put("id", cell.getUnqId());
      event.put("title", cell.getTitle());
      event.put("category", category);
      event.put("start", start);
      event.put("content", cell.getContent());
      eventList.add(event);
    }

    return eventList;
  }

  @Transactional
  public Long addEvent(CellVO cell, Long userId) {
    Long unqId = cellDAO.getNextId();
    cell.setUnqId(unqId);
    cellDAO.addEvent(cell, userId);
    return unqId;
  }

  public void deleteById(Long id) {
    cellDAO.deleteById(id);
  }

  public CellVO getEventById(Long cellId) {
    return cellDAO.getEventById(cellId);
  }

  public void setCategoryByEventId(Long categoryId, Long insertedEventId) {
    cellDAO.setCategoryByEventId(categoryId, insertedEventId);
  }

  public void moveEvent(Long id, String postDate) {
    cellDAO.moveEvnet(id, postDate);
  }

  public void updateEvent(CellVO existingCell) {
    cellDAO.updateEvent(existingCell);
  }
}
