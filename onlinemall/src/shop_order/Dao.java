package shop_order;

import java.util.ArrayList;

public interface Dao {

	void insert(Order o);// 구매

	ArrayList<Order> selectAll(int order_type);// 구매내역/장바구니 조회

	Order select(int num);// 장바구니 상세 정보

	void update(Order o);// 장바구니: 담은 상품 주문 수정

	void delete(int num);// 장바구니: 담은 상품 삭제
}
