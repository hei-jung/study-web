package command.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import shop_mem.Member;
import shop_mem.Service;
import shop_mem.ServiceImpl;

public class EditFormCommand extends Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		setReqRes(req, res);
		Service service = new ServiceImpl();
		// 세션 객체 생성(false: 세션이 없으면 에러, true: 세션이 없으면 생성해서 반환)
		HttpSession session = req.getSession(false);
		// 로그인 때 세션에 저장한 id 꺼냄. 즉 로그인한 사람의 id
		String id = (String) session.getAttribute("id");
		// 그 id로 검색
		Member m = service.getMember(id);
		// 검색 결과를 request에 담고
		req.setAttribute("m", m);
		// 뷰 페이지로 이동. 뷰 페이지에서 request에 담은 객체를 m이라고 불러야 함.
		forward("/views/member/editForm.jsp");
	}

}
