package com.zhiyou.dao.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhiyou.model.Admin;
import com.zhiyou.model.Course;
import com.zhiyou.model.User;
@Repository
public interface BackgroundCourseDao {
	void add(Course course);
	void delete(int id);
	void update(Course course);
	List<Course> selectAll();

	List<Course> selectAllPage();
	int selectCount();
	Course selectOne(int id);

	void deleteMany(ArrayList<Integer> ids);

	
}
