package com.zhiyou.service.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;


public interface BackgroundCourseService {
	void add(Course course);
	void delete(int id);
	void update(Course course);
	
	int selectCount();
	void deleteMany(ArrayList<Integer> ids);
	Course selectOne(int id);
	List<Course> selectAllPage();
	
	
	List<Course> selectAll();
}
