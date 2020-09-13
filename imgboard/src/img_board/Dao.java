package img_board;

import java.util.ArrayList;

public interface Dao {

	void insert(ImgBoard ib);

	ArrayList<ImgBoard> selectAll();
}
