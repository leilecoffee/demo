package cn.mcsj.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String email;
	private String password;
	private String salt;
	private String name;
	private String idCard;
	private String phone;
	private String contants;
	private String contantsPhone;
	private Integer status;
	private Integer isDelete;
	private Date createTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContants() {
		return contants;
	}

	public void setContants(String contants) {
		this.contants = contants;
	}

	public String getContantsPhone() {
		return contantsPhone;
	}

	public void setContantsPhone(String contantsPhone) {
		this.contantsPhone = contantsPhone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCredentialsSalt() {
		//SecureRandomNumberGenerator
		return this.email + this.salt;
	}
}