package member;
//추상 메서드와 상수로만 구성. 조립형으로 만들기 위해서
public interface Dao {
	void insert(Member m);
	Member select(String id);
	void update(Member m);//이메일, pwd 수정
	void delete(String id);
}

//회원가입(insert) / 로그인(select) / 로그아웃 / 탈퇴(delete)
/// 내정보확인(select) / 내정보 수정(update)