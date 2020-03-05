package com.cy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.common.vo.JsonResult;
import com.cy.pj.sys.service.SysLogService;

//@Controller
//@ResponseBody
@RestController   //这个注解==Controller+ResponseBody
@RequestMapping("/log/")
public class SysLogController {
	
	@Autowired
	private SysLogService sysLogService;
	/**
	 * 基于条件查询当前页面要显示的数据，并且将记录封装到一个JsonResult，目的是
	 * 服务端返回给客户端一个状态，客户端可以基于此状态进行响应处理
	 * 
	 * @param username  根据用户名查询
	 * @param pageCurrent  根据页码值查询（上一页或者下一页）
	 * @return
	 */
	@RequestMapping("doFindLogObject")
	//@ResponseBody
	public JsonResult doFindLogObject(String username,Integer pageCurrent) {
		//System.out.println(sysUserService.findPageObject(username, pageCurrent));
		return new JsonResult(sysLogService.findPageObject(username, pageCurrent));
	}
	/**
	 * 基于客户端提交的ids删除日志信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("doDeleteObjects")
	//@ResponseBody
	public JsonResult doDeleteObject(Integer ...ids) {
		sysLogService.deleteObject(ids);
		return new JsonResult("删除成功！");
	}
}
