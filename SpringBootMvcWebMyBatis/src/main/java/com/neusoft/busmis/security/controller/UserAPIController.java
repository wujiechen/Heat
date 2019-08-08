package com.neusoft.busmis.security.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserAPIController {
	@Autowired
	private IUserService userService = null;

	/*
	 * //异常处理方法
	 * 
	 * @ExceptionHandler public ResponseEntity<String> handle(Exception ex){ return
	 * new
	 * ResponseEntity<String>(ex.getMessage(),null,HttpStatus.EXPECTATION_FAILED); }
	 */

	@PostMapping(value = "add01")
	public String add(String userid, String password, String name, int age, Date joinDate) throws Exception {

		return "OK";

	}

	@PostMapping(value = "add02")
	public String add(@RequestBody UserModel um) throws Exception {

		System.out.println(um.getName());
		System.out.println(um.getJoinDate());
		return "OK";

	}

	@RequestMapping(path = "/get/{userid}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<UserModel> getUser1(@PathVariable String userid) throws Exception {
		UserModel um = userService.getById(userid);
		// 设置响应头
		MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<String, String>();
		headersMap.add("token", "9999");
		headersMap.add("username", "CWJ");

		ResponseEntity<UserModel> resultEntity = new ResponseEntity<UserModel>(um, headersMap, HttpStatus.OK);
		return resultEntity;
	}

	/*
	 * @RequestMapping(path="/get/{userid}",method=
	 * {RequestMethod.GET,RequestMethod.POST}) public UserModel
	 * getUser(@PathVariable String userid,@RequestHeader("token")String token)
	 * throws Exception{ System.out.println(token); // System.out.println(ssid);
	 * return userService.getById(userid); }
	 */
	@RequestMapping("/list")
	public List<UserModel> getUserList() throws Exception {
		return userService.getListByAll();
	}

	// 参数：用户的ID， 功能：下载用的图像。
	@RequestMapping(path="/downphoto/{id}",method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<byte[]> downPhoto(@PathVariable String id) throws Exception {
		UserModel userModel = userService.getById(id);
		byte[] userphoto = userModel.getPhoto();

		// 设置响应头
		MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<String, String>();
		headersMap.add("Content-Type", "image/jpeg");

		ResponseEntity<byte[]> resultEntity = new ResponseEntity<byte[]>(userphoto, headersMap, HttpStatus.OK);
		return resultEntity;
	}
}
