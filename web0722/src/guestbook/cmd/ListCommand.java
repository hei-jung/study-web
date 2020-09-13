package guestbook.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class ListCommand extends Command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) { // 요청 실행
		// TODO Auto-generated method stub
		this.request = rq;
		this.response = rp;
		Service service = new ServiceImpl();
		ArrayList<Article> list = service.getAll();
		request.setAttribute("list", list);
		forward("/guestbook/list.jsp");
	}

}
