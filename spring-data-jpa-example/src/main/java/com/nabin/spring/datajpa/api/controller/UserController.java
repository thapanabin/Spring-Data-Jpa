package com.nabin.spring.datajpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nabin.spring.datajpa.api.model.User;
import com.nabin.spring.datajpa.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession){
		return userService.getUserByProfession(profession);
	}
	
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count = userService.getCountByAge(age);
		return "total no of records:"+count;
	}
	
	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable("name") String name){
		return userService.deleteUser(name);
	}
	
	@GetMapping("/findMultiCondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
		return userService.findByMultiCondition(profession, age);
	}
	
	@GetMapping("/getUsersIgnoreCase")
	public List<User> getUserByProfessionIgnoreCase(@RequestParam String profession){
		
		return userService.getUsersIgnoreCase(profession);
		
	}
	
	@GetMapping("/getSort/{field}")
	public List<User> getSortedUsers(String field){
		return userService.getUserSort(field);
	}
	
	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersByCustomQuery(){
		return userService.getUsersCustomQuery();
	}

}
