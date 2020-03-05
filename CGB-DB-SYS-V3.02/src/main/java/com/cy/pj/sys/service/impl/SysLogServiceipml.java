package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.exception.ServiceException;
import com.cy.common.properties.PaginationProperties;
import com.cy.common.vo.PageObject;
import com.cy.pj.common.util.Assert;
import com.cy.pj.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

import ch.qos.logback.core.pattern.parser.Node;

@Service
public class SysLogServiceipml implements SysLogService {
	
	@Autowired
	private SysLogDao sysLogDao;
	@Autowired
	private PaginationProperties paginationProperties;
	
	@Override
	public PageObject<SysLog> findPageObject(String username, Integer pageCurrent) {
		//1、参数校验
		//if(pageCurrent==null||pageCurrent<0)
			//throw new IllegalArgumentException("页码值不正确");
		Assert.isArgumentValid(pageCurrent==null||pageCurrent<0, "页码值不正确");
		//2、根据用户名查询总记录数并校验
		int rowCount = sysLogDao.getRowCount(username);
		//if(rowCount==0)
			//throw new ServiceException("没有找到对应的记录");
		Assert.isServiceValid(rowCount==0, "没有找到对应的记录");
		//3、查询当前页的记录信息
		int pageSize = paginationProperties.getPageSize();//页面大小
		int startIndex =paginationProperties.getPageStratIndex(pageCurrent);
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4、封装查询结果并返回
		
		return new PageObject<SysLog>(rowCount,  records,  pageCurrent, pageSize);
	}

	@Override
	public int deleteObject(Integer... ids) {
		//1、参数校验
		//if(ids==null || ids.length==0) throw new IllegalAccessError("你没有选中要删除的数据！");
		Assert.isArgumentValid(ids==null || ids.length==0, "你没有选中要删除的数据！");
		//2、删除日志信息
		int row = sysLogDao.deleteObject(ids);
		if(row==0)throw new ServiceException("该记录可能已经不存在！");
		//3、返回结果
		return row;
	}

	

}
