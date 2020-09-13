package command.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_mem.Member;
import shop_mem.Service;
import shop_mem.ServiceImpl;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		Service service = new ServiceImpl();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		service.editMember(new Member(id, pwd, null, email, null));

		redirect(req.getContextPath() + "/views/member/result.jsp");
	}

}
