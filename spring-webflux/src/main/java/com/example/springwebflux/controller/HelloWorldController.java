package com.example.springwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebflux.model.HelloWorld;
import com.example.springwebflux.service.HoldAndProcessMessage;

import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {
	
	@Autowired
	HoldAndProcessMessage holdProcessMsg;
	
	@RequestMapping(value="/{name}")
	public ResponseEntity<Mono<HelloWorld>> greetIndividual(@PathVariable("name") String name)
	{
		System.out.println("Processing for :" + name);
		Mono<HelloWorld> greetIndividual=null;
		try {
			greetIndividual = holdProcessMsg.getGreetDetail(name);
			if(greetIndividual!=null)
			{
				System.out.println("it is not null");
			}
			else
			{
				System.out.println("it is null");
			}
			System.out.println("Returning the resp for "+ name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finally Returning the resp for "+ name);
		return new ResponseEntity<Mono<HelloWorld>>(greetIndividual,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody HelloWorld hellowrld)
	{
		try {
			System.out.println("Record for " + hellowrld.getName());
			holdProcessMsg.saveGreetDetail(hellowrld.getName(), hellowrld.getGreetMsg());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/createObject",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createObject(@RequestBody HelloWorld hellowrld)
	{
		try {
			System.out.println("Record for " + hellowrld.getName());
			holdProcessMsg.saveGreetDetailObject(hellowrld);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="obj/{name}")
	public ResponseEntity<Mono<HelloWorld>> greetIndividualObj(@PathVariable("name") String name)
	{
		System.out.println("Processing for :" + name);
		Mono<HelloWorld> greetIndividual=null;
		try {
			greetIndividual = holdProcessMsg.getGreetDetailObj(name);
		
			System.out.println("Returning the resp for "+ name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finally Returning the resp for "+ name);
		return new ResponseEntity<Mono<HelloWorld>>(greetIndividual,HttpStatus.OK);
		
	}

}
