package com.zhiyou.service.s;

import java.util.ArrayList;
import java.util.List;


import com.zhiyou.model.Video;

public interface BackgroundVideoService {
	  void add(Video video);
	  void update(Video video);
	  void delete(int id);
	  void deleteIn(ArrayList<Integer> ids);
	  
	  List<Video> selectAll();
	  Video selectById(int id);
	  List<Video> selectAllLimit(int page,int number);
	  List<Video> selectLike(String speakerId,String courseId,String subject,String factor,int page,int number);
	  int selectLikeCount(String speakerId,String courseId,String subject,String factor);
}
