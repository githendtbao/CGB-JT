package com.cy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;

@RestController
@RequestMapping("/role/")
public class SysSoleController {
	
	@Autowired
	private SysRoleService sysSoleService;
	
	@RequestMapping("doFindPageObjects")
	public JsonResult findRoleObject(String username,Integer pageCurrent) {
		//sysSoleService.findAllSoleObject(username, pageCurrent);
		return new JsonResult(sysSoleService.findAllSoleObject(username, pageCurrent));
	}
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysSoleService.deleteObject(id);
		return new JsonResult("delete OK");
	}
	@RequestMapping("doUpdateObject")
	public JsonResult updateObject(SysRole entity,Integer[] menuIds) {
		sysSoleService.updateObject(entity, menuIds);
		return new JsonResult("update ok");
	}
	@RequestMapping("doSaveObject")
	public JsonResult saveObject(SysRole entity,Integer[] menuIds) {
		sysSoleService.saveObject(entity, menuIds);
		return new JsonResult("save ok");
	}
	@RequestMapping("doFindObjectById")
	public JsonResult findObjectById(Integer id) {
	
		return new JsonResult(sysSoleService.findObjectById(id));
	}
}
