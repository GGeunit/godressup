package com.godressup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.godressup.domain.ProfileVO;
import com.godressup.persistence.ProfileMapper;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileMapper profileMapper;
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout = 10, rollbackFor = {Exception.class})
	@Override
	public void addProfile(ProfileVO profile) throws Exception {
		profileMapper.insert(profile);
	}

	@Override
	public ProfileVO readProfile(int user_id) throws Exception {
		return profileMapper.selectById(user_id);
	}

	@Override
	public List<ProfileVO> readProfileList() throws Exception {
		return profileMapper.selectAll();
	}

	@Override
	public void updateProfile(ProfileVO profile) throws Exception {
		profileMapper.update(profile);
	}

	@Override
	public void deleteProfile(int user_id) throws Exception {

	}

}
