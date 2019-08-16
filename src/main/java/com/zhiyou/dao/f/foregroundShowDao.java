package com.zhiyou.dao.f;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou.model.Course;

public interface foregroundShowDao {

	List<Course> selectAllById(Integer id);
}
