package zut.cs.network.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zut.cs.network.bean.Command;
import zut.cs.network.db.DBAccess;

/**
 * 与数据库对应的操作类
 *
 */
public class CommandDao {
	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> QueryCommandList(String name,String description) {
		DBAccess dbAccess=new DBAccess();
		List<Command> commandlist =new ArrayList<Command>();
		SqlSession sqlSession=null;
		Command command=new Command();
		try {
			sqlSession=dbAccess.getSqlSession();
			command.setName(name);
			command.setDescription(description);
			commandlist=sqlSession.selectList("Command.QueryCommandList", command);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
			return commandlist;	
	}
}
