package com.example.springwebflux.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebflux.dao.ActivityRepository;
import com.example.springwebflux.model.HelloWorld;

import reactor.core.publisher.Mono;

@Service
public class HoldAndProcessMessage implements IHoldAndProcessMessage{

	@Autowired
	ActivityRepository activityRepository;
	
	public HoldAndProcessMessage()
	{
		
	}
	
	@Override
	public Mono<HelloWorld> getGreetDetail(String name) throws InterruptedException {
		// TODO Auto-generated method stub
		Mono<HelloWorld> hello=activityRepository.getMessageByName(name);
    
		return hello;
	}
    
	@Override
	public void saveGreetDetail(String name,String msg) throws InterruptedException {
		HelloWorld act = new HelloWorld(name,msg);
		activityRepository.save(act);
		
	}
	
}
