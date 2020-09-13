package shop_mem;

public interface Dao {

	void insert(Member m);// 회원가입

	Member select(String id);// 로그인, 정보확인

	void update(Member m);// 이메일, 비밀번호 수정

	void delete(String id);// 탈퇴
}
