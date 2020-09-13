package shop_prod;

import java.util.ArrayList;

public interface Service {

	void register(Product p);// 상품 등록

	ArrayList<Product> getAll();// 상품 목록(로그인 초기페이지)

	Product get(int num);// 선택 상품 정보(상세페이지)

	void editProduct(Product p);// 상품 정보 수정

	void delProduct(int num);// 상품 삭제
}
