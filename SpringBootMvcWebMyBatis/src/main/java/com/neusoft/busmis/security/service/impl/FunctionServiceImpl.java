package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.model.FunctionModel;
import com.neusoft.busmis.security.service.IFunctionService;
@Service("functionService")
//只要有异常就回滚,无论是运行时异常还是检查异常
@Transactional(rollbackFor=Exception.class)
public class FunctionServiceImpl implements IFunctionService {
	@Autowired
	private IFunctionDao functionDao = null;

	@Override
	public void add(FunctionModel functionModel) throws Exception {
		
		functionDao.create(functionModel);
		
		
	}

	@Override
	public void modify(FunctionModel functionModel) throws Exception {
		functionDao.update(functionModel);
		
	}

	@Override
	public void delete(FunctionModel functionModel) throws Exception {
		functionDao.delete(functionModel);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<FunctionModel> getListByAll() throws Exception {
		
		return functionDao.selectListByAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<FunctionModel> getListByAllWithModuleByNestedSelect() throws Exception {
		return functionDao.selectListByAllWithNestedSelect();
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<FunctionModel> getListByAllWithModuleByNestedResultMap() throws Exception {
		return functionDao.selectListByAllWithNestedResultMap();
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<FunctionModel> selectListByModule(int mno) throws Exception {
		return functionDao.selectListByModule(mno);
		
	}

	@Override
	@Transactional(readOnly=true)
	public FunctionModel selectByNo(int fno) throws Exception {
		return functionDao.selectByNo(fno);
		
	}

	@Override
	@Transactional(readOnly=true)
	public int selectCountByAll() throws Exception {
		functionDao.selectCountByAll();
		return 0;
	}

	@Override
	@Transactional(readOnly=true)
	public int selectCountByModule(int mno) throws Exception {
		functionDao.selectCountByModule(mno);
		return 0;
	}

}
