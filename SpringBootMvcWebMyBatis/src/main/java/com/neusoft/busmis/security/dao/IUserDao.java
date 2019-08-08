package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.model.UserModel;

//用户的DAO层接口
@Mapper
public interface IUserDao {
	//C方法-增加
	public void create(UserModel userModel) throws Exception;//无图片
	public void createWithPhoto(UserModel userModel) throws Exception; //有图片
	//U方法-修改
	public void update(UserModel userModel) throws Exception;
	//D方法-删除
	public void delete(UserModel userModel) throws Exception;
	//R方法-查询  取得列表，只取得用户信息不取用户关联的角色信息列表
	public List<UserModel> selectListByAll() throws Exception;
	//R方法-查询  取得列表，取得用户信息且取用户关联的角色信息列表,使用内嵌式select
	public List<UserModel> selectListByAllWithRolesByNestedSelect() throws Exception;
	//查询获取列表，获取用户信息以及用户关联的角色信息列表，使用内嵌式ResultMap
	public List<UserModel> selectListByAllWithRolesByNestedResultMap() throws Exception;
	
	//R方法-查询 取得列表，实现分页，start表示起始记录号,rows表示取得个数
	public List<UserModel> selectListByAllWithPage(@Param("start")int start,@Param("rows")int rows);
	//R方法-查询  查询返回单个对象，一般根据表的主键字段值获取
	public UserModel selectById(String id) throws Exception;
	//为用户增加角色,每次增加一个角色
	public void addRole(@Param("id")String id,@Param("roleNo")int roleNo) throws Exception;
	//为用户增加角色,每次增加多个角色
	public void addRoles(@Param("id")String id,@Param("roleNoList") int[] roleNoList) throws Exception;
	
	//删除指定用户的所有角色
	public void deleteRoles(String id) throws Exception;
	
	//取得指定角色的用户列表
	public List<UserModel> selectListByRole(int rno) throws Exception;
	//判断指定用户是否有指定角色，取得用户和角色关联的个数
	public int selectCountByUserAndRoles(@Param("id")String id,@Param("roleNo")int roleNo) throws Exception;

	//取得指定用户授予的模块列表
	public List<ModuleModel> selectModuleListByUser(String userid) throws Exception;
		
}
