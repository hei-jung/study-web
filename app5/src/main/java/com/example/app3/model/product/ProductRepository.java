package com.example.app3.model.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app3.model.member.MemberVO;

public interface ProductRepository extends JpaRepository<ProductVO, Integer> {

	List<ProductVO> findByNameLike(String name);

	List<ProductVO> findBySeller(MemberVO seller);
}
