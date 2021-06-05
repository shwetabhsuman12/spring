package com.example.springwebflux.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.springwebflux.service.HoldAndProcessMessage;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@WebFluxTest(controllers = HelloWorldController.class)
public class HelloWorldControllerTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void createMessage() {
		
		webTestClient.post()
					 .uri("/create")
					 .contentType(MediaType.APPLICATION_JSON)
					 .syncBody("{\"name\":\"suman\",\"greetMsg\":\"Hi Welcome to Labs\"}")
					 .exchange()
					 .expectStatus()
					 .is2xxSuccessful();
	}
	
}
