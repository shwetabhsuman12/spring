package com.example.asynchproj.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncHandling2 {
	 @Async
	  public CompletableFuture<String> findUser() throws InterruptedException {
		 System.out.println("Entry time in Async 2" + System.currentTimeMillis());
		 Thread.sleep(10000L);//10 sec pause
		 System.out.println("Exit time in Async 2" + System.currentTimeMillis());
	     return CompletableFuture.completedFuture("Succeed");
	 }
}
