package cmd.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmd.Command;
import member.Service;
import member.ServiceImpl;

public class OutCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		// 세션 초기화
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");

		// 데이터 삭제
		Service service = new ServiceImpl();
		service.delMember(id);

		redirect(req.getContextPath() + "/MemController?cmd=logout");
	}

}
