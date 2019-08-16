package com.zhiyou.dao.s;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Video;

public interface BackgroundVideoDao {
	  void add(Video video);
	  void update(Video video);
	  void delete(int id);
	  void deleteIn(ArrayList<Integer> ids);
	  
	  List<Video> selectAll();
	  List<Video> selectById(int id);
	  List<Video> selectAllLimit(@Param("page")int page,@Param("number")int number);
	  List<Video> selectLike(@Param("speakerId")String speakerId, @Param("courseId")String courseId,@Param("subject")String subject, @Param("factor")String factor,@Param("page")int page,@Param("number")int number); 
      int selectLikeCount(@Param("speakerId")String speakerId, @Param("courseId")String courseId,@Param("subject")String subject, @Param("factor")String factor);


}
