package com.cy.pj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Mapper
public interface SysRoleDao {
	
	/**
	 * 0根据用户点击的数据id进行查询
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 0更新角色信息
	 * @param entity
	 * @param menutId
	 * @return
	 */
	int updateObject(SysRole entity);
	
	/**
	 * 0保存角色信息
	 * @param entity
	 * @param menutId
	 * @return
	 */
	int insertObject(SysRole entity);
	
	/**
	 * 查询所有角色信息
	 * @return
	 */
	List<SysRole> findAllSoleObject(	@Param("username") String username, 
								@Param("startIndex") Integer startIndex,
								@Param("pageSize") Integer pageSize);
	
	/**
	 *   基于条件查询总记录数
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	
	@Delete("delete from sys_roles where id=#{roleId}")
	int deleteObjectByRoleId(Integer roleId);
}
