package shop_order;

import java.util.ArrayList;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void add(Order o) {
		// TODO Auto-generated method stub
		dao.insert(o);
	}

	@Override
	public ArrayList<Order> getAll(int order_type) {
		// TODO Auto-generated method stub
		return dao.selectAll(order_type);
	}

	@Override
	public Order get(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public void editOrder(Order o) {
		// TODO Auto-generated method stub
		dao.update(o);
	}

	@Override
	public void delOrder(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
