package com.zhiyou.controller.f;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhiyou.model.Course;
import com.zhiyou.model.Video;
import com.zhiyou.service.f.foregroundShowService;
import com.zhiyou.service.f.foregroundVideoService;

@Controller
public class foregroundShowController {

	@Autowired
	foregroundShowService show;
	@Autowired
	foregroundVideoService vs;
	//课程挑选
	@RequestMapping("/courseWithVideoAndSubject.do")
	public String CourseWithVideoAndSubject(String subjectId,HttpServletRequest req) {
		List<Course> list = show.selectAllById(Integer.valueOf(subjectId));
		System.out.println(list);
		if(list.isEmpty()) {
			req.setAttribute("msg", "开发中，请期待！");
			return"/index";
			
		}
		req.setAttribute("list", list);
		req.setAttribute("subjectId", subjectId);
		return "/foreground/CourseShow";
	}
	
	@RequestMapping("/videoPlay.do")
	public String VideoPlay(String video_id,String subject_id,HttpServletRequest req) {
		System.out.println(video_id);
		System.out.println("subject_id"+subject_id);
		Video video = vs.selectById(Integer.valueOf(video_id));
		System.out.println(video);
		Integer play_num = video.getPlay_num()+1;
		video.setPlay_num(play_num);
		vs.update(video);
		req.setAttribute("video", video);
		List<Course> course = show.selectAllById(Integer.valueOf(subject_id));
		System.out.println(course+"QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
		req.setAttribute("course", course);
		return "/foreground/VideoPlay";
	}
	
}
