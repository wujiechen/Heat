package com.neusoft.busmis.security.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

//用户控制类
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService = null;

	@RequestMapping("/tolist")
	public String tolist(Model model) throws Exception {
		List<UserModel> userList = userService.getListByAll();
		model.addAttribute("userList", userList);
		return "user/list";
	}

	@RequestMapping("/toregister")
	public String toregister() throws Exception {
		return "user/register";
	}

	// 用户注册后处理
	@RequestMapping("/register")
	public String register(UserModel userModel,@RequestParam(required=false)MultipartFile userphoto) throws Exception {
		if(userphoto == null || userphoto.isEmpty()) {
			System.out.println("无文件");
		}else {
			//获取原始文件名
			String fileName = userphoto.getOriginalFilename();
			//获取文件类型
			String contentType = userphoto.getContentType();
			userModel.setPhoto(userphoto.getBytes());
			userModel.setPhotoFileName(fileName);
			userModel.setPhotoContentType(contentType);
			//将文件保存到指定目录D:\\AAA
			userphoto.transferTo(new File("D:/AAA/" + fileName));
			
		}
		userService.register(userModel);
		System.out.println(userModel.getName());
		System.out.println("注册处理");
		return "user/list";
	}
	
	//用户头像的下载
	@RequestMapping("/downphoto")
	public void downphoto1(String contentType,String fileName,HttpServletResponse response) throws IOException {
		response.setContentType(contentType);
		OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream("D:/AAA/" + fileName);
		int data = 0;
		while((data = in.read())!=-1) {
			out.write(data);
		}
		in.close();
		out.flush();
		out.close();
	}

	
}
