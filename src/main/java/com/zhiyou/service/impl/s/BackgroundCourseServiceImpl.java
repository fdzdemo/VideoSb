package com.zhiyou.service.impl.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.s.BackgroundCourseDao;
import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;
import com.zhiyou.service.s.BackgroundCourseService;
@Service
public class BackgroundCourseServiceImpl implements BackgroundCourseService{
	@Autowired
	BackgroundCourseDao courseDao;

	public void add(Course course) {
		// TODO Auto-generated method stub
		courseDao.add(course);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		courseDao.delete(id);
	}

	public void update(Course course) {
		// TODO Auto-generated method stub
		courseDao.update(course);
	}

	

	public Course selectOne(int id) {
		// TODO Auto-generated method stub
		return courseDao.selectOne(id);
	}

	public void deleteMany(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		courseDao.deleteMany(ids);
	}


/*	public List<Admin> selectAllPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return courseDao.selectAllPage(page, pageSize);
	}*/
	
	public List<Course> selectAllPage() {
		// TODO Auto-generated method stub
		return courseDao.selectAllPage();
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		return courseDao.selectCount();
	}

	@Override
	public List<Course> selectAll() {
		// TODO Auto-generated method stub
		return courseDao.selectAll();
	}

	
	

}
