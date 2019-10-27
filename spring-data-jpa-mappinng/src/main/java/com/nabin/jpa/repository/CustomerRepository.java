package com.nabin.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nabin.jpa.dto.OrderResponse;
import com.nabin.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT new com.nabin.jpa.dto.OrderResponse(c.name,p.productName) FROM Customer c JOIN c.products p ")
	public List<OrderResponse> getJoinInformation();
}
