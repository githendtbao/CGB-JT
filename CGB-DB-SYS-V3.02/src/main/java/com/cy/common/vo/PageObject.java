package com.cy.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6908464804192377077L;
	//总行数
	private Integer rowCount=0;
	//当前页要呈现的记录
	private List<T> records;
	//总页数
	private Integer pageCount=0;
	//页面大小（每页要呈现的记录数）
	private Integer pageSize=3;
	//当前页码值
	private Integer pageCurrent=1;
	public PageObject(Integer rowCount, List<T> records, Integer pageCurrent, Integer pageSize) {
		super();
		this.rowCount = rowCount;
		this.records = records;
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		//计算分页的小常识  （起始页面=（当前页面-1）*页面大小）
		this.pageCount=(rowCount-1)/pageSize+1;
	}
	

}
