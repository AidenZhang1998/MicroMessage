package zut.cs.network.service;

import java.util.List;

import zut.cs.network.bean.Message;
import zut.cs.network.dao.MessageDao;

public class ListService {
public List<Message> QueryMessageList(String command,String description) {
	MessageDao messageDao= new MessageDao();		
	return messageDao.QueryMessageList(command, description);	
}
}
