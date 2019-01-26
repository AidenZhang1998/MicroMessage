package zut.cs.network.service;

import zut.cs.network.dao.MessageDao;

/**
 * 维护表单的相关功能
 *
 */
public class MaintainService {
	public void DeleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.DeleteOne(Integer.valueOf(id));
		}

	}
}
