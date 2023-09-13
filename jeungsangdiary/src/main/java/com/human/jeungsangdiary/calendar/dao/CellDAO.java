package com.human.jeungsangdiary.calendar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.jeungsangdiary.calendar.mapper.CellMapper;
import com.human.jeungsangdiary.calendar.vo.CellVO;

@Repository
public class CellDAO {
    
    @Autowired
    CellMapper cellMapper;

    public List<CellVO> getEvents() {
        return cellMapper.getEvents();
    };
}
