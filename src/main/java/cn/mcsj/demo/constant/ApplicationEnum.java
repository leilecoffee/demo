package cn.mcsj.demo.constant;

public enum ApplicationEnum {
	SUCCESS(0, "操作成功"),
	FAIL(1, "系统异常，请稍后重试!"),
	PATH_ERROR(1, "访问地址未找到"),
	LOGIN_SUCCESS(0, "登录成功"),
	LOGIN_FAIL(1, "账号或密码错误"),
	UNAUTHORIZED(1, "您没有当前操作的权限！"),
	UNLOGIN(2, "未登录"),
	ROLE_OR_PERMISSION_CHANGED(-1, "当前用户角色或权限发生改变,请重新登录!"),
	SESSION_EXPIRED(-2, "会话过期，请重新登录"),
	LOGOUT(0, "退出成功"),
	REQUEST_INVALID(3, "请求无效"),
	PASSWORD_ERROR(4, "原始密码错误,请重新输入"),
	FILE_NOT_EXISTS(1000, "文件不存在"),
	FILE_UPLOAD_ERROR(1001, "上传失败"),
	PARAM_ERROR(1002, "参数异常"),
	FILE_NOT_EMPTY(1003, "上传文件不能为空文件"),
	TEMPLATE_NOT_FOUND(1004, "模板未找到"),
	VERIFY_CODE_ERROR(1005, "验证码不正确"),
	EMAIL_NOT_EXIST(1006, "邮箱不存在,请重新输入"),

	EMAIL_SEND_ERROR(1007, "邮件发送失败,请稍后重试"),
	REGISTER_FAIL(1008, "注册失败"),
	EMAIL_VERIFY_CODE_SEND_ERROR(1009, "邮箱验证码发送失败"),
	EMAIL_VERIFY_CODE_CHECK_ERROR(1010, "邮箱验证码验证失败"),
	REGISTER_EMAIL_ISEXIST(1011, "邮箱已注册"),
	REGISTER_EMAIL_NO_VERIFY(1012, "邮箱未通过验证"),
	COMPANY_ISEXIST(1013, "公司名称或社会信用代码已存在"),
	USER_ISAUDIT(1014, "用户已审核"),
	CHAIN_ISEXIST(1015, "链名称已存在"),
	CHAIN_COMPANY_SAVE_FAIL(1016, "新增参与公司保存失败"),
	USER_IS_NOT_AUDIT(1017, "未审核及审核不通过用户不可分配角色"),
	EMAIL_HAS_SEND(1018, "邮件已发送,请勿重复操作"),
	EMAIL_VERIFY_EXCEEP_MAX_NUM(1019, "验证超过最大次数，请半小时后再试"),

	SET_ORGANIZATION_FAIL(1020, "用户添加FISCO-CC失败"),
	SET_CHAIN_INFO_FAIL(1021, "添加业务链失败"),
	UPDATE_CHAIN_INFO_FAIL(1022, "更新业务链失败"),
	STOP_CHAIN_INFO_FAIL(1023, "停用业务链失败"),

	SERVICE_APPLICATION_ISEXIST(1024, "您已接入当前服务，无需重复申请");
	private int code;

	private String message;

	private ApplicationEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
