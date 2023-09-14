package com.human.jeungsangdiary.calendar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.jeungsangdiary.calendar.mapper.CategoryCellMapper;
import com.human.jeungsangdiary.calendar.mapper.CellMapper;
import com.human.jeungsangdiary.calendar.vo.CellVO;

@Repository
public class CellDAO {
    
    @Autowired
    CellMapper cellMapper;

    @Autowired
    CategoryCellMapper categoryCellMapper;

    public List<CellVO> getEvents() {
        return cellMapper.getEvents();
    };

    public Long getLastInsertId() {
        return cellMapper.getLastInsertId();
    }

    public void addEvent(CellVO cell) {
        cellMapper.addEvent(cell);
    }

    public void deleteById(Long id) {
        cellMapper.deleteById(id);
    }

    public CellVO getEventById(Long cellId) {
        return cellMapper.getEventById(cellId);
    }

    public void setCategoryByEventId(Long categoryId, Long insertedEventId) {
        categoryCellMapper.setCategoryByEventId(categoryId, insertedEventId);
    }

    public Long getNextId() {
        return cellMapper.getNextId();
    }

    public void moveEvnet(Long id, String postDate) {
        cellMapper.moveEvent(id, postDate);
    }

    public void updateEvent(CellVO existingCell) {
        cellMapper.updateEvent(existingCell);
    };
}
