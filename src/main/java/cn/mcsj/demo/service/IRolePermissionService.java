package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.RolePermission;

public interface IRolePermissionService{
	
	RolePermission getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<RolePermission> list(Map whereMap);
	
	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(RolePermission rolePermission);

    int delete(Long primaryKey);
}
