package guestbook.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.Service;
import guestbook.ServiceImpl;

public class DelCommand extends Command {

	@Override
	public void execute(HttpServletRequest rq, HttpServletResponse rp) {
		// TODO Auto-generated method stub
		this.request = rq;
		this.response = rp;
		Service service = new ServiceImpl();
		int num = Integer.parseInt(request.getParameter("num"));
		service.delArticle(num);
		redirect("Controller?cmd=list");
	}

}
