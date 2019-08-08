package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.ModuleModel;

public interface IModuleService {
	public void add(ModuleModel moduleModel) throws Exception;
	public void modify(ModuleModel moduleModel) throws Exception;
	public void delete(ModuleModel moduleModel) throws Exception;
	//只取得模块列表，不取关联属性
	public List<ModuleModel> getListByAll() throws Exception;
	
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式select方式
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedResultMap() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式select方式
	public List<ModuleModel> getListByAllWithRolesByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> getListByAllWithRolesByNestedResultMap() throws Exception;
		
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式select方式
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionsByNestedResultMap() throws Exception;
	
	
	public ModuleModel getByNo(int mno) throws Exception;
	//取得所有模块的个数
	public int getCountByAll() throws Exception;
	//取得指定角色的模块列表
	public List<ModuleModel> getListByRole(int roleNo) throws Exception;
	//验证指定角色是否有此模块权限: 参数：模块编号，角色编号
	public boolean checkAccessForRole(int mno,int roleNo) throws Exception;
}
