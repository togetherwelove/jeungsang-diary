package com.human.jeungsangdiary.calendar.cell;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CellVO {

  private Long unqId;
  private String postDate;
  private String title;
  private String content;
  private String writeDate;

  private String categoryName;

  private List<MultipartFile> files = new ArrayList<>();

  private List<Long> removeFileIds = new ArrayList<>();
}
