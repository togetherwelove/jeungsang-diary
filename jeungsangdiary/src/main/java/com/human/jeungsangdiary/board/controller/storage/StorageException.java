package com.human.jeungsangdiary.board.controller.storage;

// Storage 오퍼레이션 수행 시 발생하는 Exception을 처리하는 클래스
public class StorageException extends RuntimeException {

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}