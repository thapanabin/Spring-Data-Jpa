package com.nabin.spring.datajpa.api.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nabin.spring.datajpa.api.dao.UserRepository;
import com.nabin.spring.datajpa.api.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initDB() {
		List<User> users = new ArrayList<>();
		users.add(new User(111,"x","IT",20));
		users.add(new User(222,"y","CIVIL",21));
		users.add(new User(333,"z","GOVT",22));
		users.add(new User(444,"w","IT",29));
		users.add(new User(555,"e","IT",20));

		userRepository.saveAll(users);

	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public List<User> getUserByProfession(String profession){
		return userRepository.findByProfession(profession);
		
	}
	
	public long getCountByAge(int age) {
		return userRepository.countByAge(age);
	}
	
	public List<User> deleteUser(String name) {
		return userRepository.deleteByName(name);
	}
	
	public List<User> findByMultiCondition(String profession,int age){
		return userRepository.findByProfessionAndAge(profession, age);
	}
	
	public List<User> getUsersIgnoreCase(String profession){
		return userRepository.findByProfessionIgnoreCase(profession);
	}
	
	//sort constructor is not found i dont know why need to fix
//	public List<User> getUserSort(String field){
//		return  userRepository.findAll(new Sort(field));
//	}
	
	//page request is not avaiable as well
	//pagination
//	public Page<User> getPaginatedUser(){
//		return userRepository.findAll(new PageRequest(0,3));
//	}

	//custom query
	public List<User> getUsersCustomQuery(){
		return userRepository.getUsersCustomQuery();
	}

	public List<User> getUserSort(String field) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@GetMapping("/getPaginatedData")
//	public List<User> getPaginatedRecords(){
//		return userRepository.getPaginatedUser();
//	}
	
	

}
