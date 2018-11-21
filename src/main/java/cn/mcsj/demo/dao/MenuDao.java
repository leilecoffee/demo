package cn.mcsj.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.mcsj.demo.entity.Menu;

@Mapper
@SuppressWarnings("rawtypes")
public interface MenuDao {
	
	Menu getOne(Long id);

	List<Menu> list(Map map);

	int total(Map map);

	int insert(Menu entity);

	int update(Menu entity);

	int delete(Long id);
}
