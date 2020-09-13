package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class WriteCommand extends Command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		this.request = rq;
		this.response = rp;
		Service service = new ServiceImpl();
		String writer = request.getParameter("writer");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		service.addArticle(new Article(0, writer, pwd, null, content));
		redirect("Controller?cmd=list");
		//redirect("/web0722/guestbook/Controller?cmd=list");
	}

}
