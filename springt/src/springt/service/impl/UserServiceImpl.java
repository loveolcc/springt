package springt.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springt.dao.UserDao;
import springt.entity.User;
import springt.service.UserService;
import springt.util.MailUtil;

@Service("userservice")
public class UserServiceImpl implements UserService{

	@Resource(name="userdao")
	private UserDao ud;
	@Override
	public void regist(User u) throws Exception {
		// TODO Auto-generated method stub
		ud.regist(u);
		MailUtil.sendMail(u.getEmail(), u.getCode());
	}
	@Override
	public String active(String code) throws Exception {
		// TODO Auto-generated method stub
		String result=ud.active(code);
		return result;
		
	}
}
