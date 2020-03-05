package com.cy.common.vo;

import java.io.Serializable;

import lombok.Data;
/**
 * 返回给客户端的数据对象
 * @author Administrator
 *
 */
@Data
public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2080943344863436345L;
	/* 表示状态码*/
	private int state=1;//1表示正确   0表示错误
	/* 表示状态信息*/
	private String message="OK"; 
	/*表示封装的数据*/
	private Object data;
	public JsonResult() {
		
	}
	public JsonResult(String message) {
		this.message=message;
	}
	public JsonResult(Object data) {
		this.data=data;
	}
	public JsonResult(Throwable t) {
		this.state=0;
		this.message=t.getMessage();
	}
}
