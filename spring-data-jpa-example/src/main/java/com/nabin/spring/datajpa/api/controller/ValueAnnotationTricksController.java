package com.nabin.spring.datajpa.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueAnnotationTricksController {
	//"${my.greeting}"
	@Value("${my.greeting: default value}")//default value will come in to effect if we dont have anything in the properties file
	private String greeting;
	
	@Value("This is static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listOfValues;
	
	@Value("#{${dbValues}}")//# after curly braces it will treat as spring expression language spel and evaluate 
	private Map<String, String> dbVal;
	
	@GetMapping("/greeting")
	public String welcome() {
		return "Hi There Good Evening"+greeting+staticMessage+listOfValues+dbVal;
	}

}
