package zut.cs.network.servlet;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zut.cs.network.bean.Message;

/*
 * 列表初始化控制
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		    req.setCharacterEncoding("UTF-8");
			String command= req.getParameter("command");
			String description =req.getParameter("description");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://114.116.163.105:3306/micro_message?useUnicode=true&characterEncoding=utf-8","root","Aa184550!");
			StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT FROM MESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();
			if (command!=null && !"".equals(command.trim())){
                sql.append(" and COMMAND=?");
                paramList.add(command);
            }
            if (description != null && !"".equals(description.trim())){
                sql.append(" and DESCRIPTION like '%' ? '%'");
                paramList.add(description);
            }
			PreparedStatement statement =conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++)
			{
				statement.setString(i+1,paramList.get(i));
			}
			ResultSet rs=statement.executeQuery();
			List<Message>messageList =new ArrayList<Message>();
			while (rs.next())
			{
				Message message =new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
			req.setAttribute("messageList", messageList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/back/index.jsp").forward(req, resp);
		//跳转
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
   
}
