package command.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_prod.Product;
import shop_prod.Service;
import shop_prod.ServiceImpl;

public class EditCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		Service service = new ServiceImpl();
		int num = Integer.parseInt(req.getParameter("num"));
		int price = Integer.parseInt(req.getParameter("price"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		String info = req.getParameter("info");
		service.editProduct(new Product(num, null, null, price, qty, null, info));

		redirect(req.getContextPath() + "/ProductController?cmd=list");
	}

}
