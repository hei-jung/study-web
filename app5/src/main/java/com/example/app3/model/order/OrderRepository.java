package com.example.app3.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app3.model.member.MemberVO;

public interface OrderRepository extends JpaRepository<OrderVO, Integer> {

	List<OrderVO> findByTypei(Integer typei);
	
	List<OrderVO> findByCon(MemberVO con);
}
