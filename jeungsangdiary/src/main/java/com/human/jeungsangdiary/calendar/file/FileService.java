package com.human.jeungsangdiary.calendar.file;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
    @Autowired
    FileMapper fileMapper;

    @Transactional
    public void saveFiles(final Long cellId, final List<FileReqeust> files) {
        if (CollectionUtils.isEmpty(files)) {
            return;
        }
        for (FileReqeust file : files) {
            file.setCellId(cellId);
        }
        fileMapper.saveAll(files);
    }

     /**
     * 파일 리스트 조회
     * @param cellId - 게시글 번호 (FK)
     * @return 파일 리스트
     */
    public List<FileResponse> findAllFileByCellId(final Long cellId) {
        return fileMapper.findAllByCellId(cellId);
    }

    /**
     * 파일 삭제
     * @param ids - PK 리스트
     */
    @Transactional
    public void deleteAllFileByIds(final List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        fileMapper.deleteAllByIds(ids);
    }
}
