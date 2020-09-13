package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class EditFormCommand extends Command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		this.request = rq;
		this.response = rp;
		int num = Integer.parseInt(request.getParameter("num"));
		Service service = new ServiceImpl();
		Article a = service.getArticle(num);
		request.setAttribute("a", a);
		forward("/guestbook/editForm.jsp");
	}

}
