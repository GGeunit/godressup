package com.godressup.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.godressup.domain.ProfileVO;

@Mapper
public interface ProfileMapper {
	void insert(ProfileVO profile);
	ProfileVO selectById(int user_id);
	List<ProfileVO> selectAll();
	void update(ProfileVO profile);
	void delete(int user_id);
}
