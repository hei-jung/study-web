package img_board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUpload {
	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img";
	private String webPath = "/img/";

	public ImgBoard upload(HttpServletRequest request) {
		ImgBoard ib = null;
		int maxSize = 10 * 1024 * 1024; // 전송파일의 최대 크기
		String format = "UTF-8";

		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, format,
					new DefaultFileRenamePolicy());
			String writer = multi.getParameter("writer");
			String title = multi.getParameter("title");// 입력양식
			File f = multi.getFile("file");// 파일업로드
			String img = webPath + f.getName();
			ib = new ImgBoard(0, writer, title, img);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ib;
	}
}
