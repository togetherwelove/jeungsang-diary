package com.human.jeungsangdiary.calendar.file;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileApiController {

  @Autowired
  FileService fileService;

  @GetMapping("/{id}/event")
  public List<FileResponse> findAllFileByCellId(
    @PathVariable("id") final Long cellId
  ) {
    return fileService.findAllFileByCellId(cellId);
  }

  @GetMapping("/download/{id}")
  public FileResponse findById(@PathVariable("id") Long id) {
    return fileService.findById(id);
  }
}
