package com.human.jeungsangdiary.board.controller.storage;

// 업로드 경로를 찾을 수 없을 때 발생하는 예외를 처리하는 클래스
public class StorageFileNotFoundException extends StorageException {

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
