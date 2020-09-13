package img_comment;

import java.util.ArrayList;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addImgComment(ImgComment ic) {
		// TODO Auto-generated method stub
		dao.insert(ic);
	}

	@Override
	public ArrayList<ImgComment> getAll(int img_num) {
		// TODO Auto-generated method stub
		return dao.selectAll(img_num);
	}

}
