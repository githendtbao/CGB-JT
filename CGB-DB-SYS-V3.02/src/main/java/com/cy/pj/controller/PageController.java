package com.cy.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 在此Controller中处理请求页面的响应
 * @author hendt
 *
 */
@Controller
@RequestMapping("/")
public class PageController {
	
	/**
	 * 请求主页面
	 * @return
	 */
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		//System.out.println("=================");
		return "starter";
	}
	
	/**
	 *请求分页
	 * @return
	 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		//System.out.println("uuu----");
		
		return "common/page";
	}
	/**
	 * 请求日志数据
	 * @return
	 */
//	@RequestMapping("log/log_list")
//	public String doFindLog() {
//		return "sys/log_list";
//	}
//	@RequestMapping("/menu/menu_list")
//	public String doFindMenus() {
//		return "sys/menu_list";
//	}
	
	
	/**
	 * rest风格（软件架构的编码风格的url）
	 * {}为rest编码风格的表达式，（内容是自己定义的变量）
	 * @PathVariable  注解告诉spring mvc框架 方法的monduleUI来自url
	 * @param monduleUI
	 * @return
	 */
	@RequestMapping("{mondu}/{monduleUI}")
	public String doModule(@PathVariable String monduleUI) {
		
		return "sys/"+monduleUI;
	}
	
}
