package com.example.app3.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app3.model.member.MemberVO;


//Dao(interface)
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
	//반환타입 findBy컬럼명();
	//반환타입 findBy컬럼명like();
	List<MyOrder> findByConid(MemberVO con);
}
