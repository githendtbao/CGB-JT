package com.cy.pj.sys.service;

import java.util.List;

import com.cy.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

import ch.qos.logback.core.pattern.parser.Node;

public interface SysLogService {
	/**
	   *  基于分页查询当前用户行为日志信息
	 * @param username  用户名
	 * @param pageCurrent   当前页码值
	 * @return  根据分页显示日志信息
	 */
	PageObject<SysLog> findPageObject(String username,Integer pageCurrent);
	
	/**
	 * 基于多个id删除日志信息
	 * @param ids
	 * @return
	 */
	int deleteObject(Integer ...ids);
	
		
	
}
