package cn.mcsj.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mcsj.demo.constant.PageConstant;
import cn.mcsj.demo.dao.UserDao;
import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.User;
import cn.mcsj.demo.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public User getOne(Long primaryKey) {
		return userDao.getOne(primaryKey);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<User> list(Map whereMap) {
		return userDao.list(whereMap);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean page(PageBean page, Map whereMap) {
		whereMap.put(PageConstant.PAGE_START, page.getStart());
		whereMap.put(PageConstant.PAGE_SIZE, page.getPageSize());
		int total = userDao.total(whereMap);
		List<User> rows = new ArrayList<User>();
		if (total > 0) {
			rows = list(whereMap);
		}
		page.setRows(rows);
		page.setTotal(total);
		return page;
	}

	@Transactional
	@Override
	public int save(User user) {
		Long userId = user.getUserId();
		if (userId == null) {
			return userDao.insert(user);
		} else {
			return userDao.update(user);
		}
	}

	@Override
	public int delete(Long primaryKey) {
		return userDao.delete(primaryKey);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public User getUserByEmail(String email) {
		Map whereMap = new HashMap();
		whereMap.put("email", email);
		List<User> userList = list(whereMap);
		if (userList.size() == 1) {
			return userList.get(0);
		}
		return null;
	}
}
