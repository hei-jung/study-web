package fileUploadDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileService {

	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\data";

	public void upload(HttpServletRequest request) {
		int maxSize = 10 * 1024 * 1024; // 전송파일의 최대 크기
		String format = "UTF-8";
		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, format,
					new DefaultFileRenamePolicy());

			String title = multi.getParameter("title");// 입력양식
			multi.getFile("file");// 파일업로드

		} catch (Exception e) {
			e.printStackTrace();
		}
		fileList(request);
	}

	public void download(HttpServletRequest request, HttpServletResponse response, String fname) {

		InputStream in = null;
		OutputStream os = null;
		File file = null;

		try {
			file = new File(path, fname);
			in = new FileInputStream(file);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}

		String client = request.getHeader("User-Agent");

		response.reset();
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Description", "JSP Generated Data");
//
//		if (client.indexOf("MSIE") != -1) {
//			try {
//				response.setHeader("Content-Disposition",
//						"attachment; filename=" + new String(fname.getBytes("KSC5601"), "ISO8859_1"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} else {
			// 한글 파일명 처리
			try {
				fname = new String(fname.getBytes("utf-8"), "iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fname + "\"");
			response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
		// }

		response.setHeader("Content-Length", "" + file.length());

		try {
			os = response.getOutputStream();
			byte b[] = new byte[(int) file.length()];
			int leng = 0;

			while ((leng = in.read(b)) > 0) {
				os.write(b, 0, leng);
			}

			in.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fileList(HttpServletRequest request) {
		File dir = new File(path);
		String[] flist = dir.list();
		request.setAttribute("flist", flist);
	}
}
