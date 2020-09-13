package shop_prod;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUpload {
	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
	private String webPath = "/shop_img/";

	public Product upload(HttpServletRequest request) {
		Product p = null;
		int maxSize = 10 * 1024 * 1024; // 전송파일의 최대 크기
		String format = "UTF-8";

		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, format,
					new DefaultFileRenamePolicy());
			/* 입력양식 */
			String s_id = multi.getParameter("s_id");
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			int qty = Integer.parseInt(multi.getParameter("qty"));
			// 파일업로드
			File f = multi.getFile("file");
			String img = webPath + f.getName();
			String info = multi.getParameter("info");
			p = new Product(0, s_id, name, price, qty, img, info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
}
