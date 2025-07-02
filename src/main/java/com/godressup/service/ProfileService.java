package com.godressup.service;

import java.util.List;

import com.godressup.domain.ProfileVO;

public interface ProfileService {
	public void addProfile(ProfileVO profile) throws Exception;
	public ProfileVO readProfile(int user_id) throws Exception;
	public List<ProfileVO> readProfileList() throws Exception;
	public void updateProfile(ProfileVO profile) throws Exception;
	public void deleteProfile(int user_id) throws Exception;
}
