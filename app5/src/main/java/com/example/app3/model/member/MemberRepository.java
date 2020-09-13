package com.example.app3.model.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO, String> {

	List<MemberVO> findByTypei(Integer typei);

}
