package command.prod;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_prod.Product;
import shop_prod.Service;
import shop_prod.ServiceImpl;

public class ListCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		Service service = new ServiceImpl();
		ArrayList<Product> list = service.getAll();
		req.setAttribute("list", list);
		forward("/views/member/seller.jsp");
	}

}
