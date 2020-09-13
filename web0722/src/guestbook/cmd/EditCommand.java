package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Article;
import guestbook.Service;
import guestbook.ServiceImpl;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		this.request = rq;
		this.response = rp;
		Service service = new ServiceImpl();
		int num = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("content");
		service.editArticle(new Article(num, "", "", null, content));
		redirect("Controller?cmd=list");
	}

}
