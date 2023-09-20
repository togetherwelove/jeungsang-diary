package com.human.jeungsangdiary.calendar.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileApiController {
    @Autowired
    FileService fileService;

    @GetMapping("/event/{id}/files")
    public List<FileResponse> findAllFileByCellId(@PathVariable("id") final Long cellId) {
        return fileService.findAllFileByCellId(cellId);
    }
}
