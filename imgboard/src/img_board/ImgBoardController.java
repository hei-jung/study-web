package img_board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img_comment.ImgComment;

/**
 * Servlet implementation class ImgBoardController
 */
@WebServlet("/ImgBoardController")
public class ImgBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImgBoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		Service service = new ServiceImpl();// º»¹®
		img_comment.Service service_cmt = new img_comment.ServiceImpl();// ´ñ±Û

		if (cmd == null) {
			cmd = "ad";
		}

		switch (cmd) {
		case "write":// º»¹®
			FileUpload fu = new FileUpload();
			ImgBoard ib = fu.upload(request);
			service.addImgBoard(ib);
			break;
		case "write_cmt":// ´ñ±Û
			int img_num = Integer.parseInt(request.getParameter("img_num"));
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			service_cmt.addImgComment(new ImgComment(0, img_num, writer, content));
			break;
		}

		ArrayList<ImgBoard> list = service.getAll();
		for (ImgBoard ib : list) {
			ib.setComments(service_cmt.getAll(ib.getNum()));
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/imgboard/list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
