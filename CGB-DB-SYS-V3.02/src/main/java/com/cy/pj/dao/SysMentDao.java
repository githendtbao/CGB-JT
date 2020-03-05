package com.cy.pj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;



@Mapper
public interface SysMentDao {
	
	/**
	 *  根据菜单Id进行查询对应的子菜单id
	 * @param id
	 * @return
	 */
	int getChlidCount(Integer id);
	
	/**
	 * 根据菜单id删除菜单
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObject(Integer id);
	
		
	/**
	 *  查询所有菜单以及上级菜单ID和名称
	 * @return 所有菜单映射为一个集合（一行记录映射为一个map，所有的key为字段名，值是value）
	 *  为什么使用map ？
	 *  1、Map本身就是一个容器，原本就可以存储数据
	 *  2、使用Map存储数据可以省略pojo的定义，这个也是最大的优劣
	 *  3、使用Map可读性差（打开Map的源码不知道存储了什么数据），值类型不可控（Object）
	 *  
	 */
	List<Map<String,Object>> findObject();
	
	/**
	 * 查找所有菜单的id节点返回
	 * @return
	 */
	@Select("select id,name, parentId from sys_menus ")
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 根据用户填入菜单数据进行保存
	 * @param sysMenu
	 * @return
	 */
	int insertObject(SysMenu sysMenu);
	
	/**
	 * 更新菜单数据
	 * @param sysMenu
	 * @return
	 */
	int updateObject(SysMenu sysMenu);
}
