package com.human.jeungsangdiary.calendar.service;

import com.human.jeungsangdiary.calendar.dao.CategoryDAO;
import com.human.jeungsangdiary.calendar.dao.CellDAO;
import com.human.jeungsangdiary.calendar.vo.CellVO;
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

  public List<Map<String, Object>> getEventList() {
    List<Map<String, Object>> eventList = new ArrayList<Map<String, Object>>();
    Map<String, Object> event = new HashMap<>();

    List<CellVO> cells = cellDAO.getEvents();

    for (CellVO cell : cells) {
      event = new HashMap<>();
      String title = categoryDAO.getCategoryNameByCellId(cell.getUnqId());
      String start = cell.getPostDate();
      event.put("id", cell.getUnqId());
      event.put("title", title);
      event.put("start", start);
      event.put("content", cell.getContent());
      eventList.add(event);
    }

    return eventList;
  }

  @Transactional
  public Long addEvent(CellVO cell) {
    Long newId = cellDAO.getNextId();
    cell.setUnqId(newId);
    cellDAO.addEvent(cell);
    return newId;
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
