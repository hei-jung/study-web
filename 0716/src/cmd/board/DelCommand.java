package cmd.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Service;
import board.ServiceImpl;
import cmd.Command;

public class DelCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		
		Service service = new ServiceImpl();
		int num = Integer.parseInt(req.getParameter("num"));
		service.delBoard(num);
		
		redirect(req.getContextPath()+"/BoardController?cmd=list");
	}

}
