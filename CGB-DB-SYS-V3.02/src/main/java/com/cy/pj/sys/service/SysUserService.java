package com.cy.pj.sys.service;

import com.cy.common.vo.PageObject;

public interface SysUserService {
	
	/**
	 * 基于id更换用户启用和禁用状态
	 * @param id
	 * @param valid
	 * @return
	 */
	int updateValidById(Integer id,Integer valid);
	
	/**
	 * -基于用户名查询用户信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject findPageObjects(String username,Integer pageCurrent);
}
