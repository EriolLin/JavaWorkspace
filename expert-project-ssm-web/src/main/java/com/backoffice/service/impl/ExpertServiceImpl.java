package com.backoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backoffice.mapper.ExpertMapper;
import com.backoffice.model.Expert;
import com.backoffice.model.ExpertExample;
import com.backoffice.service.IExpertService;

@Service
@Transactional
public class ExpertServiceImpl implements IExpertService{
	
	@Autowired
	ExpertMapper expertMapper;
	
	@Override
	public Expert findByid(int id) {
		return expertMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Expert> findAllExpert() {
		ExpertExample expertExample = new ExpertExample();
		return expertMapper.selectByExample(expertExample);
	}

	@Override
	public void saveOrUpdate(Expert expert) {
		if(expert.getId() == null) {
			expertMapper.insert(expert);
		}else {
			expertMapper.updateByPrimaryKeySelective(expert);
		}
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
