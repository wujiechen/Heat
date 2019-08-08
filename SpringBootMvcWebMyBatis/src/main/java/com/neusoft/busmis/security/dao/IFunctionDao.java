package com.neusoft.busmis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.busmis.security.model.FunctionModel;

@Mapper
public interface IFunctionDao {
	public void create(FunctionModel function) throws Exception;
	public void update(FunctionModel function) throws Exception;
	public void delete(FunctionModel function) throws Exception;
	//取得所有系统功能列表,不取关联的模块对象。
	public List<FunctionModel> selectListByAll() throws Exception;
	//使用内嵌式select模式取得关联的模块对象
	public List<FunctionModel> selectListByAllWithNestedSelect() throws Exception;
	//使用内嵌式ResultMap模式取得关联的模块对象
	public List<FunctionModel> selectListByAllWithNestedResultMap() throws Exception;
	
	//取得指定模块系统功能列表,参数:mno 模块编号
	public List<FunctionModel> selectListByModule(int mno) throws Exception;
	//取得指定的系统功能对象
	public FunctionModel selectByNo(int fno) throws Exception;
	//取得所有功能的个数
	public int selectCountByAll() throws Exception;
	
	//取得指定模块的功能的个数,参数:mno 模块编号
	public int selectCountByModule(int mno) throws Exception;
}
