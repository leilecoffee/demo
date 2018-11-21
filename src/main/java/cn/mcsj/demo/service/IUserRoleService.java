package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.UserRole;

public interface IUserRoleService{
	
	UserRole getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<UserRole> list(Map whereMap);
	
	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(UserRole userRole);

    int delete(Long primaryKey);
}
