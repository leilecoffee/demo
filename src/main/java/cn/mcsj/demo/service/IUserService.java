package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.User;

public interface IUserService{
	
	User getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<User> list(Map whereMap);
	
	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(User user);

    int delete(Long primaryKey);
    
    User getUserByEmail(String email);
}
