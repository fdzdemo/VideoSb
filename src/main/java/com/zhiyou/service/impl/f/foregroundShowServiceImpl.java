package com.zhiyou.service.impl.f;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.f.foregroundShowDao;
import com.zhiyou.model.Course;
import com.zhiyou.service.f.foregroundShowService;
@Service
public class foregroundShowServiceImpl implements foregroundShowService {

	@Autowired
	foregroundShowDao dao;
	public List<Course> selectAllById(Integer id) {
		
		return dao.selectAllById(id);
	}

}
