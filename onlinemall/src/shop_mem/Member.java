package shop_mem;

public class Member {

	private String id;// 회원 id
	private String pwd;// 회원 비밀번호
	private String name;// 회원 이름
	private String email;// 회원 이메일
	private String type;// 회원 유형(판매자or구매자)

	public Member() {
	}

	public Member(String id, String pwd, String name, String email, String type) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", type=" + type + "]";
	}

}
