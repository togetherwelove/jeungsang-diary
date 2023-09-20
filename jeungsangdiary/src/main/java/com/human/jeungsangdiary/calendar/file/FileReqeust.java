package com.human.jeungsangdiary.calendar.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileReqeust {
    private Long id;
    private Long cellId;
    private String originName;
    private byte[] imageData;
    private Long imgSize;

    // 빌더 패턴으로 만들어주는 롬복 어노테이션
    @Builder
    public FileReqeust (String originName, Long imgSize, byte[] imageData) {
        this.originName = originName;
        this.imgSize = imgSize;
        this.imageData = imageData;
    }

    /**
     * 이벤트 생성 후 파일 처리를 위한 메서드
     * 생성된 게시글 ID를 파일 요청 객체의 cellId에 저장
    */
    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }
}
