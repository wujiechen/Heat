package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;

//用户的业务接口
public interface IUserService {
	//注册用户
	public void register(UserModel userModel) throws Exception;
	//修改用户
	public void modify(UserModel userModel) throws Exception;
	//修改密码
	public void changePasswowrd(String id, String password) throws Exception;
	//修改角色
	public void changeRole(String id, String role) throws Exception;
	//验证用户合法性
	public boolean validate(String id, String password) throws Exception;
	//激活用户，可以登录
	public void active(String id) throws Exception;
	//终止用户，此用户不能登录
	public void disable(String id) throws Exception;
	//删除用户
	public void delete(UserModel userModel) throws Exception;
	
	//取得所有用户列表
	//R方法-查询  取得列表
	public List<UserModel> getListByAll() throws Exception;
	
	//取得用户列表，并取得关联的角色属性列表，使用内嵌式select方式
	public List<UserModel> getListByAllWithRolesByNestedSelect() throws Exception;
	//查询获取列表，获取用户信息以及用户关联的角色信息列表，使用内嵌式ResultMap
	public List<UserModel> getListByAllWithRolesByNestedResultMap() throws Exception;
	
	
	//rows表示每页记录条数，page表示页号
	public List<UserModel> getListByAllWithPage(int rows,int page) throws Exception;
	
	//R方法-查询  查询返回单个对象，一般根据表的主键字段值获取
	public UserModel getById(String id) throws Exception;
	
	public void addRoles(String id,int[] roleNos) throws Exception;
	
	public void addRole(String id,int roleNo) throws Exception;
	
	//取得指定用户的被授予的模块列表
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception;
		

}
