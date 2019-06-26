package com.sample.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TodoApplication extends SpringBootServletInitializer
{
 	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
