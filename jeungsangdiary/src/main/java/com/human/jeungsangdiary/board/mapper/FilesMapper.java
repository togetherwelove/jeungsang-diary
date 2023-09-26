package com.human.jeungsangdiary.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.human.jeungsangdiary.board.domain.Files;

@Mapper
public interface FilesMapper {
    
    public int insertFiles(Files upfiles) throws Exception;
	
	public Files selectFilesList(int boardId) throws Exception;

}
