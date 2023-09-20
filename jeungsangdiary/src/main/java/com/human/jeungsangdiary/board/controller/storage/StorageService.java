package com.human.jeungsangdiary.board.controller.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

//  업로드 디렉터리 파일 입출력 연산을 나타내는 Interface
public interface StorageService {

	// 저장소를 초기화
	void init();

	// 주어진 MultipartFile 객체에 있는 파일을 저장
	void store(MultipartFile file);

	// 저장소에 있는 모든 파일의 경로를 스트림으로 반환
	Stream<Path> loadAll();

	// 주어진 파일 이름에 해당하는 파일의 경로를 반환
	Path load(String filename);

	// 주어진 파일 이름에 해당하는 파일을 리소스 형태로 반환(예: URL, File 등)
	Resource loadAsResource(String filename);

	// 저장소에 있는 모든 파일을 삭제
	void deleteAll();

}
