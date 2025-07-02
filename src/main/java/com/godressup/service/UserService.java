package com.godressup.service;

import java.util.List;

import com.godressup.domain.ProfileVO;
import com.godressup.domain.UserVO;

public interface UserService {
	public void signup(UserVO user, ProfileVO profile) throws Exception;
	public void addUser(UserVO user) throws Exception;
	public UserVO readUser(String username) throws Exception;
	public List<UserVO> readUserList() throws Exception;
	public void updateUser(UserVO user) throws Exception;
	public void deleteUser(String username) throws Exception;
}
