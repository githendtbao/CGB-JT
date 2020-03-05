package com.cy.pj.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cy.common.vo.JsonResult;
/**
 * 当controller层的类中发现了异常，在本类又没有处理异常，框架会在com.cy中查找有没有ControllerAdvice描述的类进行处理
 * @ControllerAdvice 此注解描述的类是控制层全局异常处理类
 * @return
 */
//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class GlobaExceptionHandler {
	/**
	 * ExceptionHandler(RuntimeException.class)描述方法为异常处理方法，注解是框架内部定义
	 * @param e  方法参数一般是ExceptionHandler(RuntimeException.class)里面的参数，或者是里面参数的父类
	 * ExceptionHandler(RuntimeException.class)《RuntimeException e
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	//@ResponseBody
	public JsonResult doHandlerRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}

}
