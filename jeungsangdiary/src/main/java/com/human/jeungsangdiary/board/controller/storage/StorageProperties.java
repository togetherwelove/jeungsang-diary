package com.human.jeungsangdiary.board.controller.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 파일이 업로드될 경로
@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
