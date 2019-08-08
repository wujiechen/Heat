package com.neusoft.busmis.security.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.RoleModel;

public interface IRoleService {
	public void add(RoleModel roleModel) throws Exception;

	public void modify(RoleModel roleModel) throws Exception;

	public void delete(RoleModel roleModel) throws Exception;

	
	public RoleModel selectByNo(int rno) throws Exception;

	// 取得指定用户的角色列表
	public List<RoleModel> getListByUser(String id) throws Exception;
	//R方法-查询  取得列表，取得角色信息且取角色关联的用户信息列表,使用内嵌式select
	public List<RoleModel> getListByAllWithUsersByNestedSelect() throws Exception;
	//查询获取列表，获取角色信息以及角色关联的用户信息列表，使用内嵌式ResultMap
	public List<RoleModel> getListByAllWithUsersByNestedResultMap() throws Exception;
		

	//R方法-查询  取得列表，取得角色信息且取角色关联的模块信息列表,使用内嵌式select
	public List<RoleModel> getListByAllWithModulesByNestedSelect() throws Exception;
	//查询获取列表，获取角色信息以及角色关联的模块信息列表，使用内嵌式ResultMap
	public List<RoleModel> getListByAllWithModulesByNestedResultMap() throws Exception;
		
	
	// 取得所有角色的个数
	public int getCountByAll() throws Exception;

	public void deleteUsers(int rno) throws Exception;

	// 为角色添加一个用户
	public void addUser(@Param("rno") int rno, @Param("id") String id) throws Exception;

	// 为角色添加多个用户
	public void addUsers(@Param("rno") int rno, @Param("idList") String[] idList) throws Exception;
}
