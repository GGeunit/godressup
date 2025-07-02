package com.godressup.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.godressup.domain.UserVO;
import com.godressup.service.UserService;

@RestController
@RequestMapping(value="/user/rest")
public class UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired(required=true)
	private UserService userService;
	
	//@GetMapping("/{username}")
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public ResponseEntity<UserVO> readUser(@PathVariable("username") String username) throws Exception {
		UserVO user = userService.readUser(username);
		logger.info("/user/rest/{username} REST-API GET method called. then method executed.");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		
		return new ResponseEntity<UserVO>(user, headers, HttpStatus.OK);
	}
	
	//@GetMapping("/{id}")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<UserVO>> readUserList() throws Exception {
		List<UserVO> userList = userService.readUserList();
		logger.info("/user/rest/list REST-API GET method called. then readUserList method executed.");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		
		return new ResponseEntity<List<UserVO>>(userList, headers, HttpStatus.OK);
	}
	
	// @PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public String createUserPost(@RequestBody UserVO vo) throws Exception {
		userService.addUser(vo);
		logger.info(vo.toString());
		logger.info("/user/rest/{id} REST-API POST method called. then method executed.");
		
		return "OK";
	}
}