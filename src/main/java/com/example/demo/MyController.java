package com.example.demo;
import models.Greeting;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyController {
	
	private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") //The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
	    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) { //permette che scrivendo ?name=qualcosa dopo /greeting nella richiesta %s diventi qualcosa. 
	        return new Greeting(counter.incrementAndGet(), String.format(template, name));

	
	}
}
