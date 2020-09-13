package com.example.app2.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {

	List<MyOrder> findByType(OrderType type);
}
