package guestbook.cmd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command { // 추상 메서드 하나라도 포함하는 추상 클래스

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public abstract void execute(HttpServletRequest rq, HttpServletResponse rp);	// 요청 실행(요청의 종류에 따라 동작이 다르기 때문에 추상메서드로 구현)

	public void forward(String url) {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void redirect(String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
