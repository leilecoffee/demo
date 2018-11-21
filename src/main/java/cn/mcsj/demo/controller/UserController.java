package cn.mcsj.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mcsj.demo.dto.base.ResultVO;
import cn.mcsj.demo.dto.req.ReqLoginBean;
import cn.mcsj.demo.dto.req.ReqRegisterBean;
import cn.mcsj.demo.dto.req.ReqRegisterSendEmailBean;

/**
 * 
 * @Description: 用户controller
 * @author admin
 * @date 2018年11月21日 下午5:00:35
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	public ResultVO login(@Valid @RequestBody ReqLoginBean loginBean) {
		return new ResultVO();
	}

	@PostMapping("/register")
	public ResultVO register(@Valid @RequestBody ReqRegisterBean registerBean) {
		return new ResultVO();
	}

	@PostMapping("/register/send")
	public ResultVO registerSendEmail(@Valid @RequestBody ReqRegisterSendEmailBean registerSendEmailBean) {
		return new ResultVO();
	}

	@PostMapping("/logout")
	public ResultVO logout() {
		return new ResultVO();
	}

}
