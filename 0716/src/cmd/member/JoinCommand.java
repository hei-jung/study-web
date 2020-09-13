package cmd.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmd.Command;
import member.Member;
import member.Service;
import member.ServiceImpl;

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

		service.join(new Member(id, pwd, name, email));
		redirect(req.getContextPath() + "/MemController?cmd=loginForm");
	}

}
