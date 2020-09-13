package cmd.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmd.Command;
import member.Member;
import member.Service;
import member.ServiceImpl;

public class LoginCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		
		Service service = new ServiceImpl();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		HttpSession session = req.getSession(); // ¼¼¼Ç °´Ã¼ È¹µæ
		Member m = service.getMember(id);
		String path = "/views/member/loginForm.jsp";
		if (m != null) {
			if (pwd.equals(m.getPwd())) {
				session.setAttribute("id", id);
				path = "/views/member/result.jsp";
			}
		}
		forward(path);
	}

}
