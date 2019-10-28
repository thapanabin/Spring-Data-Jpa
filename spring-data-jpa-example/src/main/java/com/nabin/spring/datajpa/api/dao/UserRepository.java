package com.nabin.spring.datajpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nabin.spring.datajpa.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByProfession(String profession);
	
	public long countByAge(int age);
	
	public List<User> deleteByName(String name);
	
	//multicondition
	public List<User>findByProfessionAndAge(String profession,int age);
	
	
	//ignore case
	public List<User> findByProfessionIgnoreCase(String profession);

	//@Modifying for update and delete operation using custom query
	@Query("select u from User u")
	public List<User> getUsersCustomQuery();

//	public List<User> getPaginatedUser();

}
