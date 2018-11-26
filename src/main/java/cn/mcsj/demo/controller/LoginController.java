package cn.mcsj.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.mcsj.demo.constant.ApplicationEnum;
import cn.mcsj.demo.constant.GlobalConstant;
import cn.mcsj.demo.dto.base.ResultVO;
import cn.mcsj.demo.dto.req.ReqLoginBean;
import cn.mcsj.demo.dto.req.ReqRegisterBean;
import cn.mcsj.demo.dto.req.ReqRegisterSendEmailBean;
import cn.mcsj.demo.dto.res.ResLoginBean;
import cn.mcsj.demo.entity.User;
import cn.mcsj.demo.service.IEmailService;
import cn.mcsj.demo.service.IUserService;
import cn.mcsj.demo.util.ApplicationUtil;
import cn.mcsj.demo.util.SerializeUtil;

/**
 * 
 * @Description: 用户controller
 * @author admin
 * @date 2018年11月21日 下午5:00:35
 *
 */
@RestController
public class LoginController {
	@Autowired
	private IUserService userService;
	@Autowired
	private SessionDAO sessionDAO;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/login")
	public ResultVO login(@Valid @RequestBody ReqLoginBean loginBean) {
		try {
			Subject subject = SecurityUtils.getSubject();
			String email = loginBean.getUsername();
			String password = loginBean.getPassword();
			String vcode = loginBean.getImagecode();
			if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(vcode)) {
				return new ResultVO(ApplicationEnum.PARAM_ERROR);
			}
			Session session = ApplicationUtil.getSession();
			// 图形验证码
			Object imageCode = session.getAttribute(GlobalConstant.LOGIN_IMAGE_CODE);
			if (imageCode == null || !((String) imageCode).equalsIgnoreCase(vcode)) {
				return new ResultVO(ApplicationEnum.VERIFY_CODE_ERROR);
			} else {
				session.removeAttribute(GlobalConstant.LOGIN_IMAGE_CODE);
			}

			ResLoginBean userInfo = new ResLoginBean();
			// 未认证
			if (!subject.isAuthenticated()) {
				UsernamePasswordToken token = new UsernamePasswordToken(email, password);
				subject.login(token);
				// 存放用户信息到session
				User user = userService.getUserByEmail(email);
				// 剔除其他此账号在其它地方登录
				List<Session> loginedList = getLoginedSession(user.getUserId());
				for (Session loginedSession : loginedList) {
					sessionDAO.delete(loginedSession);
				}
				logger.info("写入当前用户到session中");
				session.setAttribute(GlobalConstant.SESSION_AUTH_LOGIN_USER, SerializeUtil.serialize(user));
				userInfo.setName(user.getName());
			} else {
				// 存放用户信息到session
				User user = ApplicationUtil.getCurrentUser();
				userInfo.setName(user.getName());
			}
			logger.info("登录成功,返回用户信息：" + JSON.toJSONString(userInfo));
			return new ResultVO(true, ApplicationEnum.LOGIN_SUCCESS, userInfo);
		} catch (AuthenticationException e) {
			logger.error(e.getMessage());
			return new ResultVO(ApplicationEnum.LOGIN_FAIL);
		}
	}

	// 遍历同一个账户的session
	private List<Session> getLoginedSession(Long userId) {
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		List<Session> loginedList = new ArrayList<Session>();
		for (Session session : sessions) {
			Object obj = session.getAttribute(GlobalConstant.SESSION_AUTH_LOGIN_USER);
			User user = (User) SerializeUtil.unserialize(((byte[]) obj));
			if (user != null) {
				if (userId.equals(user.getUserId())) {
					sessionDAO.delete(session);
					loginedList.add(session);
				}
			}
		}
		return loginedList;
	}

	@PostMapping("/register")
	public ResultVO register(@Valid @RequestBody ReqRegisterBean registerBean) {
		return new ResultVO();
	}

	@PostMapping("/register/send")
	public ResultVO registerSendEmail(@Valid @RequestBody ReqRegisterSendEmailBean registerSendEmailBean) {
		return new ResultVO();
	}

	/**
	 * 注销
	 * 
	 * @return void
	 */
	@PostMapping("/logout")
	public ResultVO logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return new ResultVO(true, ApplicationEnum.LOGOUT);
	}

}
