package command.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_mem.Member;
import shop_mem.Service;
import shop_mem.ServiceImpl;

public class JoinCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		Service service = new ServiceImpl();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String type = req.getParameter("type");

		service.signUp(new Member(id, pwd, name, email, type));
		redirect(req.getContextPath() + "/MemController?cmd=loginForm");
	}

}
