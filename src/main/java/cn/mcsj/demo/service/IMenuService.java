package cn.mcsj.demo.service;

import java.util.List;
import java.util.Map;

import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.Menu;

public interface IMenuService{
	
	Menu getOne(Long primaryKey);

	@SuppressWarnings("rawtypes")
	List<Menu> list(Map whereMap);
	
	@SuppressWarnings("rawtypes")
	PageBean page(PageBean page, Map whereMap);

	int save(Menu menu);

    int delete(Long primaryKey);
}
