package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.Role;

public interface IRoleService{
	
	Role getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<Role> list(Map whereMap);
	
	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(Role role);

    int delete(Long primaryKey);
}
