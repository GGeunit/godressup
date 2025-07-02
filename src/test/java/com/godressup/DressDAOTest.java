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
import com.godressup.domain.DressVO;
import com.godressup.persistence.DressMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class DressDAOTest {
	
	@Autowired
	private DressMapper dressMapper;
	
	private static Logger logger = LoggerFactory.getLogger(DressDAOTest.class);
	
	//@Test
	public void testDressMapperInsert() throws Exception {
		DressVO vo = new DressVO();
		vo.setName("Test Dress");
		vo.setPrice(0);
		vo.setSize("FREE");
		vo.setColor("Test Color");
		vo.setImage_url("Test");
		try {
			dressMapper.insert(vo);
			logger.info("vo.toString(): " + vo.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testDressMapperSelectById() throws Exception {
		try {
			DressVO vo = dressMapper.selectById(1);
			logger.info("vo.toString(): " + vo.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testDressMapperSelectAll() throws Exception {
		try {
			List<DressVO> list = dressMapper.selectAll();
			logger.info("list.toString(): " + list.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testDressMapperUpdate() throws Exception {
		DressVO vo = new DressVO();
		vo.setId(4); // 테스트 시 필요없는 ID로 변경해야 함
		vo.setName("Test Dress123");
		vo.setPrice(123);
		vo.setSize("123");
		vo.setColor("123");
		vo.setImage_url("123");
		try {
			dressMapper.update(vo);
			logger.info("vo.toString(): " + vo.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testDressMapperDelete() throws Exception {
		try {
			dressMapper.delete(4); // 테스트 시 필요없는 ID로 변경해야 함
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
