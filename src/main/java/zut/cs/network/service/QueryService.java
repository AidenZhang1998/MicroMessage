package zut.cs.network.service;

import java.util.List;



import zut.cs.network.bean.Message;
import zut.cs.network.dao.MessageDao;
import zut.cs.network.util.Iconst;

public class QueryService {
public List<Message> QueryMessageList(String command,String description) {
	MessageDao messageDao= new MessageDao();		
	return messageDao.QueryMessageList(command, description);	
}
/**
 * 通过指令查询自动回复的内容
 * @param command 指令
 * @return 自动回复的内容
 */
public String queryByCommand(String command) {
	MessageDao messageDao = new MessageDao();
	List<Message> messageList;
	if(Iconst.HELP_COMMAND.equals(command)) {
		messageList = messageDao.QueryMessageList(null, null);
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < messageList.size(); i++) {
			if(i != 0) {
				result.append("<br/>");
			}
			result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
		}
		return result.toString();
	}
	messageList = messageDao.QueryMessageList(command, null);
	if(messageList.size() > 0) {
		return messageList.get(0).getContent();
	}
	return Iconst.NO_MATCHING_CONTENT;
}
}
