package com.cy.sys.dao;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.dao.SysMentDao;

@SpringBootTest
public class MenuTest {
	
	@Autowired
	private SysMentDao sysMentDao;
	
	@Test
	public void testSysMenut() {
		List<Map<String,Object>> list = sysMentDao.findObject();
		System.out.println(list.size());
		
	}
	@Test
	public void getChlidMenus() {
		System.out.println(sysMentDao.getChlidCount(8));
	}
}
