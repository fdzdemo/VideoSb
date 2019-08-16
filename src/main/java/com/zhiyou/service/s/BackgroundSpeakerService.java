package com.zhiyou.service.s;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou.model.Speaker;

public interface BackgroundSpeakerService {
	List<Speaker> selectAll();
	Speaker SelectById(int id);


	void add(Speaker speaker);
	void update(Speaker speaker);
	void delete(int id);
	void deleteIn(ArrayList<Integer> ids);
}
