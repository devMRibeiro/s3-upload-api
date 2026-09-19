package br.com.devmribeiro.s3uploader.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.devmribeiro.s3uploader.service.UploadService;

@RestController
@RequestMapping("/files")
public class FileController {
	
	private final UploadService uploadService;

	public FileController(UploadService uploadService) {
		this.uploadService = uploadService;
	}
	
	@PostMapping
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
		uploadService.upload(file);
        return ResponseEntity.ok().build();
    }
}