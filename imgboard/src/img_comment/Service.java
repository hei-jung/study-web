package img_comment;

import java.util.ArrayList;

public interface Service {

	void addImgComment(ImgComment ic);

	ArrayList<ImgComment> getAll(int img_num);
}
