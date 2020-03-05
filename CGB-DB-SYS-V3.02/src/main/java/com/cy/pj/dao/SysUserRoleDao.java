package com.cy.pj.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
	
	/**
	 * 0基于角色id删除用户角色表的数据
	 * @param roleId
	 * @return
	 */
	@Delete("delete from sys_user_roles where id=#{roleId}")
	int deleteObjectByRoleId(Integer roleId);
}
