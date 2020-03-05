package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * POJO(普通的JAVA对象)
 * 1）PO（持久化对象）：与面中的字段有--映射关系
 * 2）VO(value Object):封装的是业务数据（一般没有与表中一一映射关系）
 * 
 * @author Administrator
 *
 */
@Data
public class SysLog implements Serializable{

	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6109936073801089334L;
	private Integer id;
	//用户名
	private String username;
	//调用方法
	private String method;
	//用户操作
	private String opeartion;
	//调用方法执行时间
	private Long time;
	//调用方法参数
	private String params;
	//ip地址
	private String ip;
	//创建时间
	private Date createdTime;

}
