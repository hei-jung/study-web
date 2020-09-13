package member;

public interface Service {
	void join(Member m);

	boolean login(String id, String pwd);

	Member getMember(String id);

	void editMember(Member m);

	void delMember(String id);
}
