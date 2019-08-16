package com.zhiyou.dao.s;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhiyou.model.Speaker;
@Repository
public interface BackgroundSpeakerDao {

	  List<Speaker> selectAll();
	  List<Speaker> selectById(int id);

	
	  void add(Speaker speaker);
	  void update(Speaker speaker);
	  void delete(int id);
	  void deleteIn(ArrayList<Integer> ids);
}
