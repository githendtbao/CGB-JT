package com.cy.sys.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

@SpringBootTest
public class logTest {
	
	@Autowired
	private SysLogDao sysLogDao;
	
	@Test
	public void testUsernameLog() {
		int row = sysLogDao.getRowCount("a");
		System.out.println("row="+row);
	}
	@Test
	public void testFindPageObject() {
		List<SysLog> listLog = sysLogDao.findPageObjects("a",0,3);
		System.out.println("listLog="+listLog);
		for(SysLog log : listLog) {
			System.out.println(log);
		}
	}
	@Test
	public void testDeleteObject() {
		//Integer[] ids = {1,2,3};
		System.out.println(sysLogDao.deleteObject(100,200));
	}
}
