package command.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_prod.Service;
import shop_prod.ServiceImpl;

public class DelCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		Service service = new ServiceImpl();
		int num = Integer.parseInt(req.getParameter("num"));
		service.delProduct(num);

		redirect(req.getContextPath() + "/ProductController?cmd=list");
	}

}
