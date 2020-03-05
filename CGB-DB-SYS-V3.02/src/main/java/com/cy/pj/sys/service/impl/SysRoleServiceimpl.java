package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.properties.PaginationProperties;
import com.cy.common.vo.PageObject;

import com.cy.pj.common.util.Assert;
import com.cy.pj.dao.SysRoleDao;
import com.cy.pj.dao.SysRoleMenuDao;
import com.cy.pj.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.vo.SysRoleMenuVo;


@Service
public class SysRoleServiceimpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysSoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private PaginationProperties paginationProperties;


	@Override
	public int updateObject(SysRole entity, Integer[] menutids) {
		//1:校验参数
		Assert.isArgumentValid(entity==null, "更新对象为空");
		Assert.isArgumentValid("".equals(entity.getName()), "更新角色名字不能为空");
		//2:更新角色信息
		int row = sysSoleDao.updateObject(entity);
		Assert.isServiceValid(row<=0, "未知原因更新失败");
		//3:更新角色信息与菜单信息关系
		sysRoleMenuDao.deleteObjectByRoleId(entity.getId());
		int roleMenurow = sysRoleMenuDao.insertObject(entity.getId(), menutids);
		//4:返回
		return row;
	}

	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		//1:校验参数
		Assert.isArgumentValid(id<0, "未选中数据");
		//2:查询数据
		SysRoleMenuVo sysRoleMenuVo = sysSoleDao.findObjectById(id);
		//3:校验查询结果
		Assert.isServiceValid(sysRoleMenuVo==null, "此记录已经不存在");
		//4:返回数据
		return sysRoleMenuVo;
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menutIds) {
		//1:校验参数
		Assert.isArgumentValid(entity==null, "保存对象为空");
		Assert.isArgumentValid("".equals(entity.getName()), "保存角色名字不能为空");
		//2:保存角色信息
		int row = sysSoleDao.insertObject(entity);
		Assert.isServiceValid(row<=0, "未知原因保存失败");
		//3:保存角色信息与菜单信息关系
		int roleMenurow = sysRoleMenuDao.insertObject(entity.getId(), menutIds);
		//4:返回
		return row;
	}

	@Override
	public PageObject<SysRole> findAllSoleObject(String username, Integer pageCurrent) {

		//1：校验参数
		Assert.isArgumentValid(pageCurrent==null || pageCurrent<0, "页码值不正确");
		//2：获取页面信息总数
		int rowCount = sysSoleDao.getRowCount(username);
		Assert.isServiceValid(rowCount<0, "还没有配置任何数据");
		int PageSize =paginationProperties.getPageSize();
		int StratIndex = paginationProperties.getPageStratIndex(pageCurrent);
		//3：查询所有角色信息
		List<SysRole> records = sysSoleDao.findAllSoleObject(username,StratIndex, PageSize);
		//4：返回数据
		return new PageObject<SysRole>(rowCount,records,StratIndex,PageSize);
	}

	@Override
	public int deleteObject(Integer roleId) {
		//1:校验参数
		Assert.isArgumentValid(roleId==null ||roleId<1, "id值无效");
		//2:执行删除
		//删除用户角色信息
		sysUserRoleDao.deleteObjectByRoleId(roleId);
		//删除菜单角色信息
		sysRoleMenuDao.deleteObjectByRoleId(roleId);
		int row = sysSoleDao.deleteObjectByRoleId(roleId);
		//3:验证是否成功
		Assert.isServiceValid(row<0, "未知原因，删除不成功");
		//4:返回数据
		return row;
	}











}
