package com.cy.pj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;
/**
 * 定义日志数据层接口：SysLogDao
 * 在此接口中定义访问用户行为日志的规范
 * @author Administrator
 *
 */
@Mapper
public interface SysLogDao {
	
	/**
	 * 基于条件查询总记录数
	 * 1）username如果为空就是查询所有
	 * 2）username如果不为空就是查询该用户的日志信息
	 * @Param   username  查询条件（查询那个用户的所有信息）
	 * @return  总记录数据（基于这个结果算总页数）
	 * 说明：假如如下方法没有使用注解修饰，在基于名字进行查询
	 * 时候会出现There is no getter for property named
	 * 'username' in 'class java.lang.String'
	 */
	int getRowCount(@Param("username")String username);
	
	/**
	 * 基于条件分布查询日志信息
	 * @param username  查询条件(例如查询哪个用户的日志信息)
	 * @param startIndex  当前页的起始位置
	 * @param pageSize    当前页的页面大小
	 * @return      当前页的日志记录信息
	 * 数据库中每条日志信息封装到一个SysLog对象中
	 */
	List<SysLog> findPageObjects(@Param("username") String username,
								@Param("startIndex") Integer startIndex,
								@Param("pageSize") Integer pageSize);
	
	
	/**
	 * 根据多个参数id号进行删除数据
	 * @param ids
	 * @return 返回受影响的行数
	 */
	
	int deleteObject(@Param("ids") Integer ...ids );
	
	
	
}
