package com.godressup.service;

import java.util.List;

import com.godressup.domain.DressVO;

public interface DressService {
	public void addDress(DressVO dress) throws Exception;
	public DressVO readDress(int id) throws Exception;
	public List<DressVO> readDressList() throws Exception;
	public void update(DressVO dress) throws Exception;
	public void delete(int id) throws Exception;
}
