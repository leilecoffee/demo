package cn.mcsj.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mcsj.demo.constant.GlobalConstant;
import cn.mcsj.demo.dao.RoleDao;
import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.Role;
import cn.mcsj.demo.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleDao roleDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Role getOne(Long primaryKey) {
		return roleDao.getOne(primaryKey);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Role> list(Map whereMap) {
		return roleDao.list(whereMap);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean page(PageBean page, Map whereMap) {
		whereMap.put(GlobalConstant.PAGE_START, page.getStart());
		whereMap.put(GlobalConstant.PAGE_SIZE, page.getPageSize());
		int total = roleDao.total(whereMap);
		List<Role> rows = new ArrayList<Role>();
		if (total > 0) {
			rows = list(whereMap);
		}
		page.setRows(rows);
		page.setTotal(total);
		return page;
	}

	@Transactional
	@Override
	public int save(Role role) {
		Long roleId = role.getRoleId();
		if (roleId == null) {
			return roleDao.insert(role);
		} else {
			return roleDao.update(role);
		}
	}

	@Override
	public int delete(Long primaryKey) {
		return roleDao.delete(primaryKey);
	}
}
