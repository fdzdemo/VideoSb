package com.zhiyou.service.impl.s;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.s.BackgroundSpeakerDao;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.s.BackgroundSpeakerService;
@Service
public class BackgroundSpeakerServiceImpl implements BackgroundSpeakerService{

	@Autowired
	BackgroundSpeakerDao speakerDao;
	
	public List<Speaker> selectAll() {
		
		return speakerDao.selectAll();
	}

	public Speaker SelectById(int id) {
		List<Speaker> selectById = speakerDao.selectById(id);
		if(selectById.size()>0) {
			return selectById.get(0);
		}
		return null;
	}

	public void add(Speaker speaker) {
		speakerDao.add(speaker);
		
	}

	public void update(Speaker speaker) {
		speakerDao.update(speaker);
		
	}

	public void delete(int id) {
		speakerDao.delete(id);
		
	}

	public void deleteIn(ArrayList<Integer> ids) {
		speakerDao.deleteIn(ids);
		
	}

}
