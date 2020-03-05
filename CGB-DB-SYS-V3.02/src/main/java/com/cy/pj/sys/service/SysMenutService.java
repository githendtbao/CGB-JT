package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;



public interface SysMenutService {
	
	/**
	 * 根据菜单id进行删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 查询所有菜单以及菜单上的父级菜单名字
	 * @return
	 */
	List<Map<String,Object>> findObject();
	
	/**
	 * 查询所有菜单节点id
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 保存用户输入菜单信息
	 * @param sysMenu
	 * @return
	 */
	int saveObject(SysMenu sysMenu);
	
	/**
	 * 保存用户输入菜单信息
	 * @param sysMenu
	 * @return
	 */
	int updateObject(SysMenu sysMenu);
}
