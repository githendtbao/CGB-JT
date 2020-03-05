package com.cy.pj.sys.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.properties.PaginationProperties;
import com.cy.common.vo.PageObject;
import com.cy.pj.common.util.Assert;
import com.cy.pj.dao.SysUserDao;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Service
public class SysUserServiceipml implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private PaginationProperties paginationProperties;
	
	@Override
	public int updateValidById(Integer id, Integer valid) {
		//1:校验参数
		Assert.isArgumentValid(id<1, "id值无效");
		Assert.isArgumentValid(valid!=1&&valid!=0, "状态值异常");
		//2:执行与校验结果
		int row = sysUserDao.updateValidById(id, valid, "admin");
		Assert.isServiceValid(row<1, "数据可能已经不存在");
		//3:返回
		return row;
	}
	
	@Override
	public PageObject findPageObjects(String username, Integer pageCurrent) {
		//1:校验参数
		Assert.isArgumentValid(pageCurrent==null || pageCurrent<0, "页面码值不正确");
		//2：查询所有记录
		int rowCount = sysUserDao.getRowCount(username);
		//2：验证结果
		Assert.isArgumentValid(rowCount<=0, "没有找到任何记录");
		//3：查询所有用户信息
		int pageSize = paginationProperties.getPageSize();
		int startIndex = paginationProperties.getPageStratIndex(pageCurrent);
		List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
		//5：返回数据 
		return new PageObject<SysUserDeptVo>(rowCount, records, pageCurrent, pageSize);
	}



	

}
