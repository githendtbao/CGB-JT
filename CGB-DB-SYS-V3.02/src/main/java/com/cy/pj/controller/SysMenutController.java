package com.cy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenutService;

@RestController
@RequestMapping("/menu/")
public class SysMenutController {
	
	@Autowired
	private SysMenutService sysMenutService;
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysMenutService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindObjects")
	public JsonResult doFindMenutObject(){
		
		return new JsonResult(sysMenutService.findObject());
	}
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes() {
		
		return new JsonResult(sysMenutService.findZtreeMenuNodes());
	}
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysMenu sysMenu) {
		
		sysMenutService.saveObject(sysMenu);
		return new JsonResult("save OK");
	}
	@RequestMapping("doUpdateObject")
	public JsonResult doupdataObject(SysMenu sysMenu) {
		sysMenutService.updateObject(sysMenu);
		return new JsonResult("updata OK");
	}
}
