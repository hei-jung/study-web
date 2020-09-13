package cmd.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.Service;
import board.ServiceImpl;
import cmd.Command;

public class ListCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		Service service = new ServiceImpl();
		ArrayList<Board> list = service.getAll();
		req.setAttribute("list", list);
		forward("/views/board/list.jsp");
	}

}
