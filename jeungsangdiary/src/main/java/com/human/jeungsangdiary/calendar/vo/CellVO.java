package com.human.jeungsangdiary.calendar.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CellVO {
    private Long unqId;
    private String postDate;
    private String content;
    private String writeDate;

    private List<MultipartFile> files = new ArrayList<>();

    private List<Long> removeFileIds = new ArrayList<>();
}
