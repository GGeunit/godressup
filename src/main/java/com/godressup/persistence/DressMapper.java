package com.godressup.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.godressup.domain.DressVO;

@Mapper
public interface DressMapper {
	void insert(DressVO dress);
	DressVO selectById(int id);
	List<DressVO> selectAll();
	void update(DressVO dress);
	void delete(int id);
}
