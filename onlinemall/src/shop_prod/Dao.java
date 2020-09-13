package shop_prod;

import java.util.ArrayList;

public interface Dao {

	void insert(Product p);// 상품 등록

	ArrayList<Product> selectAll();// 상품 목록(로그인 초기페이지)

	Product select(int num);// 선택 상품 정보(상세페이지)

	void update(Product p);// 상품 정보 수정

	void delete(int num);// 상품 삭제

}
