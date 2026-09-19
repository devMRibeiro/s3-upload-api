package br.com.devmribeiro.s3uploader.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class UploadService {

	private final S3Client s3Client;
	
	public UploadService(S3Client s3Client) {
		this.s3Client = s3Client;
	}

	public void upload(MultipartFile file) {
		
		if (file == null || file.isEmpty())
		    throw new IllegalArgumentException("Arquivo não informado");
		
		try {
			
			PutObjectRequest request = PutObjectRequest.builder()
					.bucket("dev-mribeiro-537275298215-us-east-1-an")
					.key(file.getOriginalFilename())
					.build();
			
			s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

		} catch (AwsServiceException | SdkClientException | IOException e) {
			e.printStackTrace();
		}
	}
}