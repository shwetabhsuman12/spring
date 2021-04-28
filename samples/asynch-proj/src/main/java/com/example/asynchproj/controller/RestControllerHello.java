package com.example.asynchproj.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.asynchproj.services.AsyncHandling1;
import com.example.asynchproj.services.AsyncHandling2;

@RestController
public class RestControllerHello {

	private AsyncHandling1 async1;
	private AsyncHandling2 async2;
	
	RestControllerHello(AsyncHandling1 async1,AsyncHandling2 async2)
	{
		this.async1=async1;
		this.async2=async2;
	}
	@GetMapping("/hello")
	public String helloworld() throws InterruptedException {
		
		// Start the clock
	    long start = System.currentTimeMillis();
	   // Thread.sleep(10000L);
		CompletableFuture<String> result1=async1.findUser();
		CompletableFuture<String> result2=async2.findUser();
		while(!result1.isDone() && !result2.isDone()) {}
		// end the clock
	    long end = System.currentTimeMillis();
	    System.out.println("Total time taken: " + (end - start));
		return "succeed";
	}
}
