package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
