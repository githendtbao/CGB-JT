 package com.cy.pj.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	
	
	
	int insertObject(@Param("roleId")Integer roleId,
					 @Param("menutIds")Integer[] menutIds);
	
	/**
	 *  	0根据子菜单id进行删除子菜单
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_role_menus where id=#{Menuid}")
	int deleteObjectByMenuId(Integer menuid);
	
	/**
	 *     0基于色菜单ID删除角色菜单关系表的数据
	 * @param roleId
	 * @return
	 */
	@Delete("delete from sys_role_menus where role_id=#{roleId}")
	int deleteObjectByRoleId(Integer roleId);
}
