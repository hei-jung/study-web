package com.example.app2.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderService {

	@Autowired
	private MyOrderRepository rep;

	// 주문 담기, 수정
	public void updateOrder(MyOrder o) {
		rep.save(o);
	}

	// 주문 취소
	public void delOrder(Integer num) {
		rep.deleteById(num);
	}

	// 주문번호로 검색
	public MyOrder getByNum(Integer num) {
		return rep.getOne(num);
	}
	
	// 주문타입으로 검색
	public List<MyOrder> getByType(OrderType type){
		return rep.findByType(type);
	}

	// 전체주문목록
	public List<MyOrder> getAll() {
		return rep.findAll();
	}
}
