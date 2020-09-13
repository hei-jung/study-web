package command.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_prod.Product;
import shop_prod.Service;
import shop_prod.ServiceImpl;

public class DetailCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		int num = Integer.parseInt(req.getParameter("num"));
		Service service = new ServiceImpl();
		Product p = service.get(num);
		req.setAttribute("p", p);
		forward("/views/product/detail.jsp");
	}

}
