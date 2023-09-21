package com.human.jeungsangdiary.calendar.file;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

  /**
   * 단일 파일 업로드
   * @param multipartFile - 파일 객체
   * @return DB에 저장할 파일 정보
   */
  public FileReqeust uploadFile(final MultipartFile multipartFile) {
    if (multipartFile.isEmpty()) {
      return null;
    }

    byte[] imageData;

    try {
      imageData = multipartFile.getBytes();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return FileReqeust
      .builder()
      .originName(multipartFile.getOriginalFilename())
      .imgSize(multipartFile.getSize())
      .imageData(imageData)
      .build();
  }

  /**
   * 다중 파일 업로드
   * @param multipartFiles - 파일 객체 List
   * @return DB에 저장할 파일 정보 List
   */
  public List<FileReqeust> uploadFiles(
    final List<MultipartFile> multipartFiles
  ) {
    List<FileReqeust> files = new ArrayList<>();
    for (MultipartFile multipartFile : multipartFiles) {
      if (multipartFile.isEmpty()) {
        continue;
      }
      files.add(uploadFile(multipartFile));
    }
    return files;
  }
}
