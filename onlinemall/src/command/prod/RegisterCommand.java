package command.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import shop_prod.FileUpload;
import shop_prod.Product;
import shop_prod.Service;
import shop_prod.ServiceImpl;

public class RegisterCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);

		Service service = new ServiceImpl();
		FileUpload fu = new FileUpload();
		Product p = fu.upload(req);
		service.register(p);
		//System.out.println(p);//È®ÀÎ¿ë

		redirect(req.getContextPath() + "/ProductController?cmd=list");
	}

}
