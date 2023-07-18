package com.springboot.studentInfoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudentInfoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoProjectApplication.class, args);
	}

}
