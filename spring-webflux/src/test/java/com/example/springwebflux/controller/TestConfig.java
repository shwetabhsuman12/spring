package com.example.springwebflux.controller;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.springwebflux.service.HoldAndProcessMessage;

@TestConfiguration
public class TestConfig {
     @Bean
     public HoldAndProcessMessage holdAndProcessMessage() throws InterruptedException
     {
    	 HoldAndProcessMessage holdAndProcessMessage = new HoldAndProcessMessage();
    	 holdAndProcessMessage.saveGreetDetail("suman", "Hi this is lab");
    	 return holdAndProcessMessage;
     }
}
