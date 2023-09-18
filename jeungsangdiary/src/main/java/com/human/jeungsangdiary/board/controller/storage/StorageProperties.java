package com.human.jeungsangdiary.board.controller.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 파일이 업로드될 경로
@ConfigurationProperties("storage")
public class StorageProperties {

	// 파일 저장 위치
	private String location = "upload-dir";

	// getter ,setter
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
