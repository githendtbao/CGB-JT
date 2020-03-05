package com.cy.sys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.common.vo.PageObject;
import com.cy.pj.sys.service.SysLogService;

@SpringBootTest
public class PageTest {
	
	@Autowired
	private SysLogService sysUserService;
	
	@Test
	public void testFindPageObject() {
		PageObject po =
		sysUserService.findPageObject("admin", 3);
		System.out.println(po);
	}
	@Test
	public void testDeleteObject() {
		System.out.println(sysUserService.deleteObject());
	}
}
