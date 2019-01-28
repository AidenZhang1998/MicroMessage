package zut.cs.network.service;

import java.util.ArrayList;
import java.util.List;

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
}
