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
import cn.mcsj.demo.dao.MenuDao;
import cn.mcsj.demo.dto.base.PageBean;
import cn.mcsj.demo.entity.Menu;
import cn.mcsj.demo.service.IMenuService;

@Service
public class MenuService implements IMenuService {
	
	@Autowired
	private MenuDao menuDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Menu getOne(Long primaryKey) {
		return menuDao.getOne(primaryKey);
	}

	@SuppressWarnings("rawtypes")
	public List<Menu> list(Map whereMap) {
		return menuDao.list(whereMap);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean page(PageBean page, Map whereMap) {
		whereMap.put(GlobalConstant.PAGE_START, page.getStart());
		whereMap.put(GlobalConstant.PAGE_SIZE, page.getPageSize());
		int total = menuDao.total(whereMap);
		List<Menu> rows = new ArrayList<Menu>();
		if (total > 0) {
			rows = list(whereMap);
		}
		page.setRows(rows);
		page.setTotal(total);
		return page;
	}

	@Transactional
	public int save(Menu menu) {
		Long menuId = menu.getMenuId();
		if (menuId == null) {
			return menuDao.insert(menu);
		} else {
			return menuDao.update(menu);
		}
	}

	public int delete(Long primaryKey) {
		return menuDao.delete(primaryKey);
	}
}
