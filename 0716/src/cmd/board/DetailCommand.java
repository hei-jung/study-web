package cmd.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.Service;
import board.ServiceImpl;
import cmd.Command;

public class DetailCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		int num = Integer.parseInt(req.getParameter("num"));
		Service service = new ServiceImpl();
		Board b = service.getById(num);
		req.setAttribute("b", b);
		forward("/views/board/detail.jsp");
	}

}
