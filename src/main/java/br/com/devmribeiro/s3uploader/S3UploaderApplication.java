package br.com.devmribeiro.s3uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
	    exclude = DataSourceAutoConfiguration.class
)
public class S3UploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3UploaderApplication.class, args);
	}
}