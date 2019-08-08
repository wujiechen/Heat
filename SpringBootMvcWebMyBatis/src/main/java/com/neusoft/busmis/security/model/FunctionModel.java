package com.neusoft.busmis.security.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;
//功能的Model类
@Alias("Function")
@Data
public class FunctionModel implements Serializable {
	private int fno = 0;
	private String fname = null;
	private String furl = null;
	private ModuleModel module = null;
}
