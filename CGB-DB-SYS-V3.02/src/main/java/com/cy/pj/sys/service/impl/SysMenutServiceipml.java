package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.Node;
import com.cy.pj.common.util.Assert;
import com.cy.pj.dao.SysMentDao;
import com.cy.pj.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenutService;



@Service
public class SysMenutServiceipml implements SysMenutService{
	
	@Autowired
	private SysMentDao sysMentDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenutDao;
	

	@Override
	public List<Map<String, Object>> findObject() {
		
		return sysMentDao.findObject();
	}

	@Override
	public int deleteObject(Integer id) {
		
		//1:校验参数
		Assert.isArgumentValid(id==null || id<0, "id值无效");
		//2：查询菜单中是否存在子菜单，如果存在提示不能删除
		int chlidCount = sysMentDao.getChlidCount(id);
		Assert.isServiceValid(chlidCount>0, "请先删除子级菜单！");
		//3：根据关系表中先删除关系表（sys_role_menus）中的数据
		int rolewor = sysRoleMenutDao.deleteObjectByMenuId(id);
		//4：根据菜单id删除操作
		int row = sysMentDao.deleteObject(id);
		Assert.isServiceValid(row==0, "该记录不存在！");
		return row;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		
		return sysMentDao.findZtreeMenuNodes();
	}

	@Override
	public int saveObject(SysMenu sysMenu) {
		//1:验证参数
		Assert.isArgumentValid(sysMenu.getName()==null, "请填写你要保存的菜单名字");
		Assert.isArgumentValid(sysMenu.getParentId()==null||sysMenu.getParentId()==0 , "请选择你的上级菜单");
		//2:验证保存是否成功
		int row = sysMentDao.insertObject(sysMenu);
		Assert.isServiceValid(row<=0, "未知原因，保存失败");//有可能数据库连接中断，（如访问量过大）
		return row;
	}

	@Override
	public int updateObject(SysMenu sysMenu) {
		//1:验证参数
		Assert.isArgumentValid(sysMenu.getName()==null, "请填写你要保存的菜单名字");
		Assert.isArgumentValid(sysMenu.getParentId()==null||sysMenu.getParentId()==0 , "请选择你的上级菜单");
		//2:验证保存是否成功
		int row = sysMentDao.updateObject(sysMenu);
		Assert.isServiceValid(row<=0, "未知原因，保存失败");//有可能数据库连接中断，（如访问量过大）
		return row;
	}
	
	
}
