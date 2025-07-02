package com.godressup;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.godressup.config.RootConfig;
import com.godressup.domain.UserVO;
import com.godressup.persistence.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class UserDAOTest {
	
	@Autowired
	private UserMapper userMapper;
	
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	
	//@Test
	public void testMemberMapperInsert() throws Exception {
		UserVO user = new UserVO();
		user.setUsername("cmk");
		user.setPassword("1234");
		user.setEmail("kie_love@naver.com");
		try {
			userMapper.insert(user);
			logger.info("user.toString(): " + user.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testMemberMapperSelectById() throws Exception {
		UserVO user;
		try {
			user = userMapper.selectById("cmk");
			logger.info("user.toString(): " + user.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMemberMapperUpdate() throws Exception {
		UserVO user = new UserVO();
		user.setUsername("cmk");
		user.setPassword("12345678");
		user.setEmail("kie_love@naver.com");
		try {
			userMapper.update(user);
			logger.info("user.toString: " + user.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testMemberMapperDelete() throws Exception {
		try {
			userMapper.delete("cmk123");
			logger.info("delete execute.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testMemberMapperSelectAll() throws Exception {
		List<UserVO> listUser;
		try {
			listUser = userMapper.selectAll();
			logger.info("listUser.toString: " + listUser.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
