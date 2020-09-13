package com.example.app3.model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberRepository rep;

	// 추가 및 수정
	public MemberVO save(MemberVO m) {
		return rep.save(m);
	}

	// 1개 검색(id로)
	public MemberVO getById(String id) {
		return rep.getOne(id);
	}

	// 타입별 검색
	public List<MemberVO> getByMemType(int type) {
		return rep.findByTypei(type);
	}

	// 삭제
	public void delById(String id) {
		rep.deleteById(id);
	}

}
