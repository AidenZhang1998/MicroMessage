package zut.cs.network.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zut.cs.network.service.QueryService;

/*
 * 列表初始化控制
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		// 接受页面传值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		// 向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);		
		QueryService listService = new QueryService();
		//查询消息列表并传给页面
		req.setAttribute("messageList", listService.QueryMessageList(command, description));
		// 跳转页面
		req.getRequestDispatcher("/WEB-INF/jsp/back/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
