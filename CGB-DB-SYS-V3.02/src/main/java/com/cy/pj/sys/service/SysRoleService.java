package com.cy.pj.sys.service;

import com.cy.common.vo.PageObject;

import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	
	/**
	 * -基于id进行查询数据显示到update页面
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 0更新角色信息
	 * @param entity
	 * @param menutids
	 * @return
	 */
	int updateObject(SysRole entity,Integer[] menutids);
	
	/**
	 * 0根据保存角色信息，并且获取主健自增进行保存角色与菜单信息表进行保存
	 * @param entity
	 * @param menutids
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menutids);
	
	/**
	 *     根据条件查询角色数据
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysRole> findAllSoleObject(String username,Integer pageCurrent);
	
	/**
	 * 0基于角色id删除（用户与角色关系、菜单与角色关系、角色表数据）
	 * @param roleId
	 * @return
	 */
	int deleteObject(Integer roleId);

}
