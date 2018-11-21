package cn.mcsj.demo.dto.req;

/**
 * 
 * @Description: TODO(描述类)
 * @author admin
 * @date 2018年11月21日 下午5:01:57
 *
 */
public class ReqLoginBean {
	private String username;

	private String password;

	private String imagecode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagecode() {
		return imagecode;
	}

	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}

}
