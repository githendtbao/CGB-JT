package com.cy.pj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	
	/**
	 * 基于id更换用户启用和禁用状态
	 * @param id
	 * @param valid
	 * @param modifindUser
	 * @return
	 */
	@Update("update sys_users set valid=#{valid},modifiedUser=#{modifiedUser} where id=#{id}")
	int updateValidById(@Param("id")Integer id,@Param("valid")Integer valid,@Param("modifiedUser")String modifindUser);
	
	/**
	 * -根据用户名查询总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(String username);
	
	
	/**
	 * -查询所有用户信息，并且进行分页
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(@Param("username") String username,
										@Param("startIndex")Integer startIndex,
										@Param("pageSize")Integer pageSize);
}
