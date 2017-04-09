package springt.dao;

import java.sql.SQLException;

import springt.entity.User;

public interface UserDao {

	public void regist(User u) throws Exception;
	public String active(String code) throws Exception;
}
