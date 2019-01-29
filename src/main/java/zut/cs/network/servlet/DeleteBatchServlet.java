package zut.cs.network.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zut.cs.network.service.MaintainService;
/**
 * 
 *批量删除控制层
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		// 接受页面传值
		String[] ids = req.getParameterValues("id");
		MaintainService maintainService = new MaintainService();
		maintainService.DeleteBatch(ids);
		// 跳转页面 
		req.getRequestDispatcher("/List.action").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
