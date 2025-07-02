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
import com.godressup.domain.ProfileVO;
import com.godressup.persistence.ProfileMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class ProfileDAOTest {
	
	@Autowired
	private ProfileMapper profileMapper;

	private static final Logger logger = LoggerFactory.getLogger(ProfileDAOTest.class);
	
	//@Test
	public void testProfileMapperInsert() throws Exception {
		ProfileVO profile = new ProfileVO();
		profile.setUser_id(2); // 테스트에 맞게 바꿀 것
		profile.setNickname("test");
		profile.setAge(20);
		profile.setRegion("test");
		try {
			profileMapper.insert(profile);
			logger.info("profile.toString(): " + profile.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testProfileMapperSelectById() throws Exception {
		try {
			ProfileVO profile = profileMapper.selectById(2); // 테스트에 맞게 바꿀 것
			logger.info("profile.toString(): " + profile.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testProfileMapperSelectAll() throws Exception {
		try {
			List<ProfileVO> listProfile = profileMapper.selectAll();
			logger.info("listProfile.toString(): " + listProfile.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testProfileMapperUpdate() throws Exception {
		ProfileVO profile = new ProfileVO();
		profile.setUser_id(2); // 테스트에 맞게 바꿀 것
		profile.setNickname("testModify");
		profile.setAge(20);
		profile.setRegion("testModify");
		try {
			profileMapper.update(profile);
			logger.info("profile.toString(): " + profile.toString());
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	//@Test
	public void testProfileMapperDelete() throws Exception {
		try {
			profileMapper.delete(2); // 테스트에 맞게 바꿀 것
			logger.info("profileMapper.delete() execute.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
