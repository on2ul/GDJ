package com.gdu.app05.service;

import org.springframework.http.ResponseEntity;

public interface GalleryService {
	public ResponseEntity<byte[]> imageDisplay(String path, String filename); // 이미지에 관한 정보를 주면 그걸 바이트 배열로 반환해주겠다.
	
	
	
}
