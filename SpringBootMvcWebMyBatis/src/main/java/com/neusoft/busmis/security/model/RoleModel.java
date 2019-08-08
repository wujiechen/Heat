package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;
//用戶角色的Model类
@Alias("Role")
@Data
public class RoleModel implements Serializable {
	private int rno = 0;
	private String rname = null;
	//角色关联的用户列表
	private List<UserModel> users = null;
	//角色关联的模块列表
	private List<ModuleModel> modules = null;
}