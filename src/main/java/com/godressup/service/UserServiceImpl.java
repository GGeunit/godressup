package com.godressup.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.godressup.domain.ProfileVO;
import com.godressup.domain.UserVO;
import com.godressup.persistence.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProfileService profileService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10, rollbackFor = {Exception.class})
	@Override
	public void signup(UserVO user, ProfileVO profile) throws Exception {
		try {
			userMapper.insert(user); // user 저장 완료
			
			profile.setUser_id(user.getId()); // user.id를 지정해줌
			
			profileService.addProfile(profile); // profile 저장 -> 만약 실패 시 전체 롤백
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("회원가입 트랜잭션 실패!!! -> 롤백");
			throw e;
		}
		
	}
	
	@Override
	public void addUser(UserVO user) throws Exception {
		userMapper.insert(user);
	}

	@Override
	public UserVO readUser(String username) throws Exception {
		return userMapper.selectById(username);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		userMapper.update(user);
	}

	@Override
	public void deleteUser(String username) throws Exception {
		userMapper.delete(username);
	}

	@Override
	public List<UserVO> readUserList() throws Exception {
		return userMapper.selectAll();
	}
}
