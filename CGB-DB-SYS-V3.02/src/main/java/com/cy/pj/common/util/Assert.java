package com.cy.pj.common.util;

import com.cy.common.exception.ServiceException;

public class Assert {
	
	//参数校验是否正确
	public static void isArgumentValid(boolean stement,String message) {
		if(stement) {
			throw new IllegalArgumentException(message);
		}
	}
	//业务校验是否正确
	public static void isServiceValid(boolean stement,String message) {
		if(stement) {
			throw new ServiceException(message);
		}
	}
}
