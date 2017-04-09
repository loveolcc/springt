package springt.handler;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springt.entity.User;
import springt.service.UserService;
import springt.service.impl.UserServiceImpl;
import springt.util.UUIDUtil;

@Controller
public class UserController {
	
	@Resource(name="userservice")
	UserService us;
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(Model m,@ModelAttribute("user")User u){
		try {
			u.setCode(UUIDUtil.getUUID());
		us.regist(u);
			m.addAttribute("result", "已发送一封邮件至您的邮箱，请激活您的账号");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";
	}
	@RequestMapping(value="/active/{code}",method=RequestMethod.GET)
	public String active(@PathVariable("code") String code,Model m){
		try{
		String result=us.active(code);
		m.addAttribute("result", result);
		}catch(Exception e){
			m.addAttribute("result", "系统故障");
		}
		return "result";
	}
}
