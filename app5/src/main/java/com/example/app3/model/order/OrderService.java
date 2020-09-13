package com.example.app3.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app3.model.member.MemberVO;

@Service
public class OrderService {

	@Autowired
	private OrderRepository rep;

	// 주문 담기, 수정
	public OrderVO updateOrder(OrderVO o) {
		return rep.save(o);
	}

	// 주문 취소
	public void delOrder(Integer num) {
		rep.deleteById(num);
	}

	// 주문번호로 검색
	public OrderVO getByNum(Integer num) {
		return rep.getOne(num);
	}

	// 주문타입으로 검색
	public List<OrderVO> getByType(Integer typei) {
		return rep.findByTypei(typei);
	}

	// 주문자 아이디로 검색
	public List<OrderVO> getByCon_id(MemberVO con_id) {
		return rep.findByCon(con_id);
	}

	// 전체주문목록
	public List<OrderVO> getAll() {
		return rep.findAll();
	}
}
