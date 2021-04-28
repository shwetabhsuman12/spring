package com.example.asynchproj;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@ComponentScan
@EnableAsync
public class AsynchProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchProjApplication.class, args);
	}

}
