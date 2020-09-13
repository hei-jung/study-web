package shop_prod;

import java.util.ArrayList;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void register(Product p) {
		// TODO Auto-generated method stub
		dao.insert(p);
	}

	@Override
	public ArrayList<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Product get(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public void editProduct(Product p) {
		// TODO Auto-generated method stub
		dao.update(p);
	}

	@Override
	public void delProduct(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
