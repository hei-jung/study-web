package board;

import java.util.ArrayList;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addBoard(Board b) {
		// TODO Auto-generated method stub
		dao.insert(b);
	}

	@Override
	public Board getById(int num) {
		// TODO Auto-generated method stub
		return dao.selectById(num);
	}

	@Override
	public ArrayList<Board> getByWriter(String writer) {
		// TODO Auto-generated method stub
		return dao.selectByWriter(writer);
	}

	@Override
	public ArrayList<Board> getByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.selectByTitle(title);
	}

	@Override
	public ArrayList<Board> getAll() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public void editBoard(Board b) {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	@Override
	public void delBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
