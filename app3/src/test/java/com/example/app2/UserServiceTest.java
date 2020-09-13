package com.example.app2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.app2.model.join.UserService;
import com.example.app2.model.join.Usertb;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testAddUser(){
		service.addUser(
				new Usertb("aaa", "111", "namea", "aaa@email.com"));
	}
}
