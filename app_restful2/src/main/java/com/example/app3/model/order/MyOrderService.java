package com.example.app3.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app3.model.member.MemberVO;



@Service
public class MyOrderService {
	
	@Autowired
	private MyOrderRepository rep;
	
	public void addOrder(MyOrder o){
		rep.save(o);
	}
	
	public List<MyOrder> getByConid(MemberVO id){
		return rep.findByConid(id);
	}
}
