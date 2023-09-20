package com.human.jeungsangdiary.calendar.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    void saveAll(List<FileReqeust> files);

    /**
     * 파일 리스트 조회
     * @param cellId - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    List<FileResponse> findAllByCellId(Long cellId);
    
    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트
     * @return 파일 리스트
    */
    List<FileResponse> findAllByIds(List<Long> ids);

    /**
     * 파일 삭제
     * @param ids - PK 리스트
     */
    void deleteAllByIds(List<Long> ids);
}
