package com.human.jeungsangdiary.calendar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.jeungsangdiary.calendar.service.CategoryService;
import com.human.jeungsangdiary.calendar.service.CellService;
import com.human.jeungsangdiary.calendar.vo.CategoryVO;
import com.human.jeungsangdiary.calendar.vo.CellVO;


@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CellService cellService;

    @RequestMapping
    public String calendar(Model model) {
        List<CategoryVO> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "calendar/calendar";
    }

    @GetMapping("/event")
    public @ResponseBody List<Map<String, Object>> get(){
        List<Map<String, Object>> eventList = cellService.getEventList();
        if (eventList == null) {
            eventList = new ArrayList<>();
        }
        return eventList;
    }

    // 캘린더에서 이벤트를 이동할 때 PUT 요청을 처리
    @PutMapping("/event/{id}")
    public ResponseEntity<Map<String, Boolean>> move(@PathVariable("id") Long id, @RequestBody CellVO cell){
        Map<String, Boolean> response = new HashMap<>();

        try {
            cellService.moveEvent(id, cell.getPostDate());
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }

    // 새로운 데이터를 추가하는 POST 요청을 처리합니다.
    @PostMapping("/event/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> add(@PathVariable("categoryId") Long categoryId, @RequestBody CellVO cell) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            Long insertedEventId = cellService.addEvent(cell);
            cellService.setCategoryByEventId(categoryId, insertedEventId);
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }

    // 기존 데이터를 수정하는 PUT 요청을 처리합니다.
    @PutMapping("/update/{cellId}")
    public ResponseEntity<Map<String, Boolean>> update(@PathVariable("cellId") Long cellId, @RequestBody CellVO cell) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            CellVO existingCell = cellService.getEventById(cellId);

            existingCell.setPostDate(cell.getPostDate());
            existingCell.setContent(cell.getContent());
            cellService.updateEvent(existingCell);

            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
        response.put("success", false);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
    }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Long id) {
        Map<String, Boolean> response = new HashMap<>();
        try {
            cellService.deleteById(id);
            //  요청 처리가 성공적으로 완료되면 "200 OK" 상태 코드와 함께
            // { "success": true }라는 JSON 응답을 반환
            response.put("success", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            //  예외가 발생하면 "417 Expectation Failed" 상태 코드와 함께
            // { "success": false }라는 JSON 응답을 반환합니다.
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }
    
}

