package com.vishalsingh.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(
		exclude = {org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration.class}
)
@EnableTransactionManagement
public class journalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(journalAppApplication.class, args);
	}


	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory factory){
		return new MongoTransactionManager(factory);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
