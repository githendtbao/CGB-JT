package com.cy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.common.vo.PageObject;
import com.cy.pj.sys.service.SysUserService;


@RequestMapping("/user/")
@RestController
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doValidById")
	public JsonResult updateValidById(Integer id,Integer valid) {
		sysUserService.updateValidById(id, valid);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("doFindPageObjects")
	public JsonResult findPageObjects(String username,Integer pageCurrent) {
		PageObject pageObject = sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}
}
