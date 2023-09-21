package com.human.jeungsangdiary.calendar.file;

import lombok.Data;

@Data
public class FileResponse {

  private Long unqId;
  private Long cellId;
  private String originName;
  private Long imgSize;
  private byte[] imageData;
  private String deleteYn;
  private String createDate;
  private String deleteDate;
}
