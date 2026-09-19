package br.com.devmribeiro.s3uploader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

	@Value("${AWS.ACCESS_KEY_ID}")
	private String accessKeyId;

	@Value("${AWS.SECRET_ACCESS_KEY}")
	private String secretAccessKey;
	
	@Bean
	public S3Client s3Client() {
		return S3Client.builder()
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
				.region(Region.US_EAST_1)
				.build();
	}
}