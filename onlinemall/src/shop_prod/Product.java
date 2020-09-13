package shop_prod;

public class Product {

	int num;// 상품번호
	String s_id;// 판매자 id
	String name;// 제품명
	int price;// 가격
	int qty;// 재고량
	String img_path;// 이미지 경로
	String info;// 제품정보

	public Product() {
	}

	public Product(int num, String s_id, String name, int price, int qty, String img_path, String info) {
		this.num = num;
		this.s_id = s_id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.img_path = img_path;
		this.info = info;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", s_id=" + s_id + ", name=" + name + ", price=" + price + ", qty=" + qty
				+ ", img_path=" + img_path + ", info=" + info + "]";
	}

}
