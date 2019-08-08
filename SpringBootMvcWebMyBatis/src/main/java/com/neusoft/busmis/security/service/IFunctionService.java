package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.FunctionModel;

public interface IFunctionService {
	
	public void add(FunctionModel functionModel) throws Exception;
	public void modify(FunctionModel functionModel) throws Exception;
	public void delete(FunctionModel functionModel) throws Exception;
	//取得所有系统功能列表
	public List<FunctionModel> getListByAll() throws Exception;
	public List<FunctionModel> getListByAllWithModuleByNestedSelect() throws Exception;
	public List<FunctionModel> getListByAllWithModuleByNestedResultMap() throws Exception;
	
	//取得指定模块系统功能列表,参数:mno 模块编号
	public List<FunctionModel> selectListByModule(int mno) throws Exception;
	//取得指定的系统功能对象
	public FunctionModel selectByNo(int fno) throws Exception;
	//取得所有功能的个数
	public int selectCountByAll() throws Exception;
	//取得指定模块的功能的个数,参数:moduleNo 模块编号
	public int selectCountByModule(int mno) throws Exception;
}
