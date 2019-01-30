package zut.cs.network.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zut.cs.network.service.MaintainService;

import java.io.IOException;
import java.util.List;

/**
 * 列表页面初始化控制
 */
@SuppressWarnings("serial")
public class CreateOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        // 接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        if( command!=null && !"".equals(command.trim()) &&
                description!=null && !"".equals(description.trim()) &&
                content!=null && !"".equals(content.trim())
        ){
            new MaintainService().CreateOne(command, description, content);
        }
        req.getRequestDispatcher("/WEB-INF/jsp/back/message.jsp").forward(req, resp);
    }
}