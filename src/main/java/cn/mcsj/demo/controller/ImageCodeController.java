package cn.mcsj.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.mcsj.demo.util.ApplicationUtil;
import cn.mcsj.demo.util.ImageCodeUtil;

@Controller
public class ImageCodeController {

	/**
	 * 生成验证码图片
	 * 
	 * @param email
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/genimage")
	public void getImageVerifyCode(@RequestParam(required = true) String type, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Session session = ApplicationUtil.getSession();
		ImageCodeUtil validateCodeUtil = new ImageCodeUtil();
		if ("register".equals(type)) {
			session.setAttribute("register_image_code", validateCodeUtil.getCode());
		} else if ("login".equals(type)) {
			session.setAttribute("login_image_code", validateCodeUtil.getCode());
		} else if ("forgetpwd".equals(type)) {
			session.setAttribute("forgetpwd_image_code", validateCodeUtil.getCode());
		}
		validateCodeUtil.write(response.getOutputStream());
	}
}
