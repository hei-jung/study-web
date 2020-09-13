package shop_mem;

public interface Service {

	void signUp(Member m);// 회원가입

	boolean signIn(String id, String pwd);// 로그인

	Member getMember(String id);// 정보확인

	void editMember(Member m);// 이메일, 비밀번호 수정

	void delMember(String id);// 탈퇴
}
