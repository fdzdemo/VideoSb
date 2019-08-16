package com.zhiyou.dao.f;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zhiyou.model.Course;
@Repository
public interface foregroundShowDao {

	List<Course> selectAllById(Integer id);
}
