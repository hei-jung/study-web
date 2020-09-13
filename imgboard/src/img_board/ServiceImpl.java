package img_board;

import java.util.ArrayList;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addImgBoard(ImgBoard ib) {
		// TODO Auto-generated method stub
		dao.insert(ib);
	}

	@Override
	public ArrayList<ImgBoard> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
