package com.example.demo;

 
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(PersonRepository repository) {
		return args -> {
			//repository.save( new Person("A", "islam"));
		//	repository.save(new Person("B", "islam"));
		//	repository.save(new Person("C", "islam"));
		//	repository.save(new Person("D", "islam"));
		};
	}
}