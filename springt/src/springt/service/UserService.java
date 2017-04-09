package springt.service;

import springt.dao.UserDao;
import springt.entity.User;

public interface UserService {
	public void regist(User u) throws Exception;
	public String active(String code) throws Exception;
}
