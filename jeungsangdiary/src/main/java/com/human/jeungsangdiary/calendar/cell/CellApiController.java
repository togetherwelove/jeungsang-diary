package com.human.jeungsangdiary.calendar.cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.human.jeungsangdiary.calendar.category.CategoryService;
import com.human.jeungsangdiary.calendar.file.FileReqeust;
import com.human.jeungsangdiary.calendar.file.FileService;
import com.human.jeungsangdiary.calendar.file.FileUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CellApiController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CellService cellService;

    @Autowired
    FileService fileService;

    @Autowired
    FileUtil fileUtil;

    @GetMapping("/event")
    public List<Map<String, Object>> getEventsByUnqId(@SessionAttribute("userId") Long unqId) {
        List<Map<String, Object>> eventList = cellService.getEventsByUnqId(unqId);
        if (eventList == null) {
        eventList = new ArrayList<>();
        }
        return eventList;
    }

    @GetMapping("/event/{id}")
    public CellVO getEventById(@PathVariable("id") Long id) {
        return cellService.getEventById(id);
    }

    // 새로운 데이터를 추가하는 POST 요청을 처리합니다.
    @PostMapping("/event/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> add(
        @PathVariable("categoryId") Long categoryId,
        @ModelAttribute CellVO cell,
        @SessionAttribute("userId") Long userId
    ) {
        Map<String, Boolean> response = new HashMap<>();
        try {
        // 이벤트 저장
        Long insertedEventId = cellService.addEvent(cell, userId);

        // 이벤트의 카테고리 저장
        cellService.setCategoryByEventId(categoryId, insertedEventId);

        // 파일을 바이너리 데이터로 변환 후 객체로 저장 (to api)
        List<FileReqeust> files = fileUtil.uploadFiles(cell.getFiles());

        // 파일 정보 저장 (to database)
        fileService.saveFiles(insertedEventId, files);

        response.put("success", true);
        return ResponseEntity.ok(response);
        } catch (Exception e) {
        e.printStackTrace();
        response.put("success", false);
        return ResponseEntity
            .status(HttpStatus.EXPECTATION_FAILED)
            .body(response);
        }
    }

        // 캘린더에서 이벤트를 이동할 때 PUT 요청을 처리합니다.
    @PutMapping("/event/{id}")
    public ResponseEntity<Map<String, Boolean>> move(
        @PathVariable("id") Long id,
        @RequestBody CellVO cell
    ) {
        Map<String, Boolean> response = new HashMap<>();

        try {
        cellService.moveEvent(id, cell.getPostDate());
        response.put("success", true);
        return ResponseEntity.ok(response);
        } catch (Exception e) {
        e.printStackTrace();
        response.put("success", false);
        return ResponseEntity
            .status(HttpStatus.EXPECTATION_FAILED)
            .body(response);
        }
    }

    // 기존 데이터를 수정하는 PUT 요청을 처리합니다.
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Boolean>> update(
        @PathVariable("id") Long id,
        CellVO cell
    ) {
        Map<String, Boolean> response = new HashMap<>();
        try {
        CellVO existingCell = cellService.getEventById(id);
        existingCell.setTitle(cell.getTitle());
        existingCell.setPostDate(cell.getPostDate());
        existingCell.setContent(cell.getContent());

        // 이벤트 정보 수정
        cellService.updateEvent(existingCell);

        // 파일 정보 저장 (to api)
        List<FileReqeust> files = fileUtil.uploadFiles(cell.getFiles());

        // 파일 정보 저장 (to database)
        fileService.saveFiles(id, files);

        // 파일 정보 삭제 (to database)
        fileService.deleteAllFileByIds(cell.getRemoveFileIds());

        response.put("success", true);
        return ResponseEntity.ok(response);
        } catch (Exception e) {
        e.printStackTrace();
        response.put("success", false);
        return ResponseEntity
            .status(HttpStatus.EXPECTATION_FAILED)
            .body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(
        @PathVariable("id") Long id
    ) {
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
        return ResponseEntity
            .status(HttpStatus.EXPECTATION_FAILED)
            .body(response);
        }
    }
}
