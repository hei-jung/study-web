package shop_order;

import java.util.ArrayList;

public interface Service {

	void add(Order o);// 구매

	ArrayList<Order> getAll(int order_type);// 구매내역/장바구니 조회

	Order get(int num);// 장바구니 상세 정보

	void editOrder(Order o);// 장바구니: 담은 상품 주문 수정

	void delOrder(int num);// 장바구니: 담은 상품 삭제
}
