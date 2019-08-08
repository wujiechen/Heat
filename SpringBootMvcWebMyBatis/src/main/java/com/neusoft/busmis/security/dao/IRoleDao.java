package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.model.UserModel;


@Mapper
public interface IRoleDao {
	//C方法-增加角色
	public void create(RoleModel roleModel) throws Exception;
	//U方法-修改角色
	public void update(RoleModel roleModel) throws Exception;
	//D方法-删除角色
	public void delete(RoleModel roleModel) throws Exception;
	
	//R方法-查询  取得列表，只取得角色信息不取角色关联的用户信息列表
	public List<RoleModel> selectListByAll() throws Exception;
	//R方法-查询  取得列表，取得角色信息且取角色关联的用户信息列表,使用内嵌式select
	public List<RoleModel> selectListByAllWithUsersByNestedSelect() throws Exception;
	//查询获取列表，获取角色信息以及角色关联的用户信息列表，使用内嵌式ResultMap
	public List<RoleModel> selectListByAllWithUsersByNestedResultMap() throws Exception;
	

	//R方法-查询  取得列表，取得角色信息且取角色关联的模块信息列表,使用内嵌式select
	public List<RoleModel> selectListByAllWithModulesByNestedSelect() throws Exception;
		//查询获取列表，获取角色信息以及角色关联的模块信息列表，使用内嵌式ResultMap
	public List<RoleModel> selectListByAllWithModulesByNestedResultMap() throws Exception;
	
	
	//获取指定用户的角色列表
	public List<RoleModel> selectListByUser(String id) throws Exception;
	//获取指定模块的角色列表
	public List<RoleModel> selectListByModule(int mno) throws Exception;
	
	//R方法-查询  查询返回单个对象，一般根据表的主键字段值获取
	public RoleModel selectByNo(int rno) throws Exception;
	//取得所有角色的个数
	public int selectCountByAll() throws Exception;
	
	//删除指定角色的所有用户
	public void deleteUsers(int rno) throws Exception;
	
	//为角色添加一个用户
	public void addUser(@Param("rno")int rno,@Param("id")String id) throws Exception;
	//为角色添加多个用户
	public void addUsers(@Param("rno")int rno,@Param("idList")String[] idList)throws Exception;
}
