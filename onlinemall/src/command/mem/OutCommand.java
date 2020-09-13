package command.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import shop_mem.Service;
import shop_mem.ServiceImpl;

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
