package com.example.SpringApp2;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.SpringApp2.model.join.Member;
import com.example.SpringApp2.model.join.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService service;

	@Test
	public void testGetMembers() {
		ArrayList<Member> list = service.getMembers();
		System.out.println(list);
	}

	@Test
	public void testAddMember() {
		service.addMember(new Member("test", "1234", "Test", "test@mail.com"));
	}
}
