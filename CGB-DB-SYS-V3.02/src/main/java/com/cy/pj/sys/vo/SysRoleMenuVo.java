package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
/**
 * -基于对象封装角色页面要显示的数据，
 * 1）：角色自身信息id /name/note 来自于（sys_role）
 * 2):基于角色对应的菜单信息menuids（sys_role_menus）
 * -具体查询方案：
 * 	         -   单表查询   （在业务层发送两次查询，最终封装在一个对象）
 *     - 嵌套查询（数据库端需要发送两次查询）
 *     - 多表查询（在sys_role）上关联查询sys_role_menus
 * @author Administrator
 *
 */
@Data
public class SysRoleMenuVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2778704606701891857L;
	private Integer id;
	private String name;
	private String note;
	private List<Integer> menuIds;
}
