package com.zhiyou.service.impl.s;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.s.BackgroundVideoDao;
import com.zhiyou.model.Video;
import com.zhiyou.service.s.BackgroundVideoService;

;
@Service
public class BackgroundVideoServiceImpl implements BackgroundVideoService{

	@Autowired
	BackgroundVideoDao videoDao;
	
	public void add(Video video) {
		videoDao.add(video);
		
	}

	public void update(Video video) {
		videoDao.update(video);
		
	}

	public void delete(int id) {
		videoDao.delete(id);
		
	}

	public void deleteIn(ArrayList<Integer> ids) {
		videoDao.deleteIn(ids);
		
	}

	public List<Video> selectAll() {
		
		return videoDao.selectAll();
	}

	public Video selectById(int id) {
		List<Video> selectById = videoDao.selectById(id);
		if(selectById.size()>0) {
			return selectById.get(0);
		}
		return null;
	}

	public List<Video> selectAllLimit(int page, int number) {
		
		return videoDao.selectAllLimit(page, number);
	}

	public List<Video> selectLike(String speakerId,String courseId,String subject, String factor,int page,int number) {
		
		return videoDao.selectLike(speakerId,courseId,subject, factor, page, number);
	}

	public int selectLikeCount(String speakerId, String courseId, String subject, String factor) {
		
		return videoDao.selectLikeCount(speakerId, courseId, subject, factor);
	}

}
