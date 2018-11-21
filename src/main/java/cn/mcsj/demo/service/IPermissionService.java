package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.Permission;

public interface IPermissionService {

	Permission getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<Permission> list(Map whereMap);

	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(Permission permission);

	int delete(Long primaryKey);

	List<Permission> getPermissionByUserId(Long userId);
}
