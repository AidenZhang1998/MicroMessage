package zut.cs.network.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 访问数据库类
 *
 */
public class DBAccess {
 public SqlSession getSqlSession() throws IOException
 {
	 
	Reader reader=Resources.getResourceAsReader("zut/cs/network/config/Configuration.xml");
	SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(reader);
	SqlSession sqlSession =sqlSessionFactory.openSession();	
		
		
	return sqlSession;
	 
 }
}
