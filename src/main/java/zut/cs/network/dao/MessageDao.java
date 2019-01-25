package zut.cs.network.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zut.cs.network.bean.Message;

/**
 * 和message表相关的数据操作
 *
 */
public class MessageDao {

	public List<Message> QueryMessageList(String command,String description) {
		/**
		 * 根据查询条件查询消息列表
		 */
		List<Message> messageList =new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/micro_message?useUnicode=true&characterEncoding=utf-8", "root",
					"");
			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT FROM MESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();
        /*
                *  判空
        */            
			if (command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}
			
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}
			ResultSet rs = statement.executeQuery();			
			while (rs.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return messageList;
	}
}
