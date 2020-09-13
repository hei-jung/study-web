package img_comment;

import java.util.ArrayList;

public interface Dao {

	void insert(ImgComment ic);

	ArrayList<ImgComment> selectAll(int img_num);
}
