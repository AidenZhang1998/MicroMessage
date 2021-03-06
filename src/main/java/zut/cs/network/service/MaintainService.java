package zut.cs.network.service;

import java.util.ArrayList;
import java.util.List;

import zut.cs.network.bean.Message;
import zut.cs.network.dao.MessageDao;

/**
 * 维护表单的相关功能
 *
 */
public class MaintainService {
	/**
	 * 根据删除条件删除一条消息
	 */
	public void DeleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.DeleteOne(Integer.valueOf(id));
		}

	}
	/**
	 * 批量删除消息
	 */
	public void DeleteBatch(String[] ids) {
			MessageDao messageDao = new MessageDao();
			List<Integer> list =new ArrayList<Integer>();
			for(String str : ids) {
				  int i = Integer.parseInt(str);
				  list.add(i);
				}
			messageDao.DeleteBatch(list);

	}
	/**
	 * 增加消息
	 */
	public void CreateOne(String command, String description, String content) {
		// TODO Auto-generated method stub
		MessageDao messageDao = new MessageDao();
		messageDao.CreateOne(command, description, content);
	}
	 /**
     * 修改一条
     */
    public void update(String id, String command, String description, String content){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(Integer.valueOf(id));
        MessageDao messageDao = new MessageDao();
        //校验该id是否存在
        List<Message> existingMessages = messageDao.listMessageById(ids);
        if(existingMessages.size() > 0){
            Message message = new Message();
            message.setId(id);
            message.setCommand(command);
            message.setDescription(description);
            message.setContent(content);
            messageDao.Update(message);
        }
    }
}
