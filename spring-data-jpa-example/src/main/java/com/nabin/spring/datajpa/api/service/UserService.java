package com.nabin.spring.datajpa.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

}
