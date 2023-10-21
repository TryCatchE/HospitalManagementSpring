package com.example.hospital;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class HospitalApplication {

	// @Bean
	// public ModelMapper modelMapper() {
	// 	return new ModelMapper();
	// }

	public static void main(String[] args) {
		
		// System.out.println(SpringApplication.run(HospitalApplication.class, args).getBean(Patient.class).getActive());
		SpringApplication.run(HospitalApplication.class, args);

	}

	
}
