package command.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import shop_mem.Member;
import shop_mem.Service;
import shop_mem.ServiceImpl;

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
		String type = m.getType();
		String path = "/views/member/loginForm.jsp";
		if (m != null) {
			if (pwd.equals(m.getPwd())) {
				session.setAttribute("id", id);
				// path = "/views/member/result.jsp";
				switch (type) {
				case "consumer":
					path = "/views/member/consumer.jsp";
					break;
				case "seller":
					path = "/views/member/seller.jsp";
					break;
				}
			}
		}
		forward(path);
	}

}
