package com.godressup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godressup.domain.DressVO;
import com.godressup.persistence.DressMapper;

@Service
public class DressServiceImpl implements DressService {

	@Autowired
	private DressMapper dressMapper;
	
	@Override
	public void addDress(DressVO dress) throws Exception {
		dressMapper.insert(dress);
	}

	@Override
	public DressVO readDress(int id) throws Exception {
		return dressMapper.selectById(id);
	}

	@Override
	public List<DressVO> readDressList() throws Exception {
		return dressMapper.selectAll();
	}

	@Override
	public void update(DressVO dress) throws Exception {
		dressMapper.update(dress);
	}

	@Override
	public void delete(int id) throws Exception {
		dressMapper.delete(id);
	}

}
