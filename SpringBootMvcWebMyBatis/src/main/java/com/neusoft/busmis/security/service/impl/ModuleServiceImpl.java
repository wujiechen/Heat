package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.neusoft.busmis.security.dao.IModuleDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.service.IModuleService;
@Service("moduleService")
//只要有异常就回滚,无论是运行时异常还是检查异常
@Transactional(rollbackFor=Exception.class)
public class ModuleServiceImpl implements IModuleService {
	@Autowired
	private IModuleDao moduleDao = null;

	@Override
	public void add(ModuleModel moduleModel) throws Exception {
		moduleDao.create(moduleModel);
		//int m = 10/0;
		//moduleModel.setMname("AAAA");
		//moduleDao.create(moduleModel);
		
	}

	@Override
	public void modify(ModuleModel moduleModel) throws Exception {
		moduleDao.update(moduleModel);
	}

	@Override
	public void delete(ModuleModel moduleModel) throws Exception {
		moduleDao.delete(moduleModel);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAll() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAll();
		
		return list;
	}

	@Override 
	@Transactional(readOnly=true)
	public ModuleModel getByNo(int mno) throws Exception {
		
		ModuleModel moduleModel = moduleDao.selectByNo(mno);
		
		return moduleModel;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCountByAll() throws Exception {
		
		return moduleDao.selectListByAll().size();
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByRole(int roleNo) throws Exception {
		
		return (List<ModuleModel>) moduleDao.selectListByRole(roleNo);
	}

	@Override
	public boolean checkAccessForRole(int mno, int roleNo) throws Exception {
		
		return false;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedSelect() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAllWithFunctionsByNestedSelect();
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedResultMap() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAllWithFunctionsByNestedResultMap();
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAllWithRolesByNestedSelect() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAllWithRolesByNestedSelect();
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAllWithRolesByNestedResultMap() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAllWithRolesByNestedResultMap();
		
		return list;
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionByNestedSelect() throws Exception {
	
		List<ModuleModel> list = moduleDao.selectListByAllWithFunctionsAndRolesFunctionByNestedSelect();
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionsByNestedResultMap() throws Exception {
		
		List<ModuleModel> list = moduleDao.selectListByAllWithFunctionsAndRolesFunctionsByNestedResultMap();
		
		return list;
	}

}
