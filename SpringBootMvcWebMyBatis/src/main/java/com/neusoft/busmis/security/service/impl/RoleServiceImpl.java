package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IRoleDao;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.service.IRoleService;
@Service("roleService")
//只要有异常就回滚,无论是运行时异常还是检查异常
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao roleDao;

	
	@Override
	public void add(RoleModel roleModel) throws Exception {
		
		roleDao.create(roleModel);
		

	}

	@Override
	public void modify(RoleModel roleModel) throws Exception {
		
		roleDao.update(roleModel);
		

	}

	@Override
	public void delete(RoleModel roleModel) throws Exception {
		
		roleDao.delete(roleModel);
	

	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleModel> getListByUser(String id) throws Exception {
		
		// 调用Dao接口的方法
		List<RoleModel> list = roleDao.selectListByUser(id);
		
		return list;

	}

	@Override
	@Transactional(readOnly=true)
	public RoleModel selectByNo(int rno) throws Exception {

		System.out.println(roleDao.toString());
		// 调用Dao接口的方法
		RoleModel roleModel = roleDao.selectByNo(rno);
		
		return roleModel;
	}

	@Override
	@Transactional(readOnly=true)
	public int getCountByAll() throws Exception {
		
		// 调用Dao接口的方法
		int count = roleDao.selectCountByAll();
		
		return count;
	}

	@Override
	public void addUser(int rno, String id) throws Exception {
		
		// 调用Dao接口的方法
		roleDao.addUser(rno, id);
		
	}

	@Override
	public void addUsers(int rno, String[] idList) throws Exception {
		
		// 先删除用户
		roleDao.deleteUsers(rno);
		// 调用Dao接口的方法
		roleDao.addUsers(rno, idList);
		

	}

	@Override
	public void deleteUsers(int rno) throws Exception {
		

		// 调用Dao接口的方法
		roleDao.deleteUsers(rno);

	

	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleModel> getListByAllWithUsersByNestedSelect() throws Exception {
		

		// 调用Dao接口的方法
		List<RoleModel> list = roleDao.selectListByAllWithUsersByNestedSelect();

		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleModel> getListByAllWithUsersByNestedResultMap() throws Exception {
		

		// 调用Dao接口的方法
		List<RoleModel> list = roleDao.selectListByAllWithUsersByNestedResultMap();

		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleModel> getListByAllWithModulesByNestedSelect() throws Exception {
		

		// 调用Dao接口的方法
		List<RoleModel> list = roleDao.selectListByAllWithModulesByNestedSelect();

		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleModel> getListByAllWithModulesByNestedResultMap() throws Exception {

		// 调用Dao接口的方法
		List<RoleModel> list = roleDao.selectListByAllWithModulesByNestedResultMap();

		return list;
	}

}
