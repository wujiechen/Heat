package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

//用户的业务实现类
@Service("userService1")
//只要有异常就回滚,无论是运行时异常还是检查异常
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao = null;
	
	
	
	// 取得User的DAO接口对象
	// private IUserDao userDao=DaoFactory.createUserDao();
	//@Autowired
	//@Resource(name="getSSF")
	//private SqlSessionFactory sqlSessionFactory = null;
	//private int age = 0;
	//private String name = null;
	
	
	/*
	 * public void setUserDao(IUserDao userDao) { this.userDao = userDao; }
	 */
	
	
	/*
	 * public void setUserDao(IUserDao userDao) { this.userDao = userDao; }
	 */

	//@Autowired
	/*
	 * public UserServiceImpl() { super(); }
	 */
	//@Autowired
	/*
	 * public UserServiceImpl(SqlSessionFactory sqlSessionFactory, int age, String
	 * name) {
	 * 
	 * this.sqlSessionFactory = sqlSessionFactory; this.age = age; this.name = name;
	 * System.out.println("UserServiceImpl构造方法");
	 * 
	 * }
	 */
	
	//@Autowired
	//@Inject
	/*
	 * public UserServiceImpl(SqlSessionFactory sqlSessionFactory) {
	 * 
	 * this.sqlSessionFactory = sqlSessionFactory;
	 * 
	 * System.out.println("UserServiceImpl2构造方法");
	 * 
	 * }
	 */
	//@Autowired
	/*
	 * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	 * this.sqlSessionFactory = sqlSessionFactory; }
	 */

	/*
	 * public void setAge(int age) { this.age = age; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	 * this.sqlSessionFactory = sqlSessionFactory; }
	 */
	
	@Override
	public void register(UserModel userModel) throws Exception {
		
		if(userModel.getPhotoFileName()!=null) {
			userDao.createWithPhoto(userModel);
		}else {
			
			// 调用Dao接口的方法
			userDao.create(userModel);
		}
		
	}

	@Override
	public void modify(UserModel userModel) throws Exception {

		// 调用Dao接口的方法
		userDao.update(userModel);
	}

	@Override
	public void changePasswowrd(String id, String password) throws Exception {
		
		// 调用Dao接口的方法
		UserModel um = userDao.selectById(id);
		um.setPassword(password);
		userDao.update(um);
		
	}

	@Override
	public void changeRole(String id, String role) throws Exception {
		
		// 调用Dao接口的方法
		UserModel um = userDao.selectById(id);
		// um.setRole(role);
		userDao.update(um);
		

	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean result = false;
		// 调用Dao接口的方法
		UserModel um = userDao.selectById(id);
		if (um != null && um.getPassword() != null && um.getPassword().equals(password)) {
			result = true;
		}
		
		return result;
	}

	@Override
	public void active(String id) throws Exception {

		// 调用Dao接口的方法
		UserModel um = userDao.selectById(id);
		um.setStatus("Y");

		userDao.update(um);

	}

	@Override
	public void disable(String id) throws Exception {
		
		// 调用Dao接口的方法
		UserModel um = userDao.selectById(id);
		um.setStatus("Y");
		userDao.update(um);
		
	}

	@Override
	public void delete(UserModel userModel) throws Exception {
		
		// 调用Dao接口的方法
		userDao.delete(userModel);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserModel> getListByAll() throws Exception {
		
		// 调用Dao接口的方法
		List<UserModel> list = userDao.selectListByAll();
		
		return list;

	}

	// rows表示每页记录条数，page表示页号
	@Transactional(readOnly=true)
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		// 调用Dao接口的方法
		List<UserModel> list = userDao.selectListByAllWithPage(rows * (page - 1), rows);
		
		return list;

	}

	@Override
	@Transactional(readOnly=true)
	public UserModel getById(String id) throws Exception {
		
		// 调用Dao接口的方法
		UserModel userModel = userDao.selectById(id);
		

		return userModel;
	}

	public void addRoles(String id, int[] roleNos) throws Exception {
		
		// 每次增加角色前，推荐把原有的角色删掉
		userDao.deleteRoles(id);
		// 再增加新的角色
		userDao.addRoles(id, roleNos);
		
	}

	@Override
	public void addRole(String id, int roleNo) throws Exception {
		
		userDao.addRole(id, roleNo);
	
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserModel> getListByAllWithRolesByNestedSelect() throws Exception {
		
		// 调用Dao接口的方法
		List<UserModel> list = userDao.selectListByAllWithRolesByNestedSelect();

		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserModel> getListByAllWithRolesByNestedResultMap() throws Exception {
	
		// 调用Dao接口的方法
		List<UserModel> list = userDao.selectListByAllWithRolesByNestedResultMap();
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception {
		
		
		// 调用Dao接口的方法
		List<ModuleModel> list = userDao.selectModuleListByUser(userid);
		
		return list;
	}
}
