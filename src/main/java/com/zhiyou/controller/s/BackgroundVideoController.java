package com.zhiyou.controller.s;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;

import com.zhiyou.model.Video;
import com.zhiyou.service.s.BackgroundCourseService;
import com.zhiyou.service.s.BackgroundSpeakerService;
import com.zhiyou.service.s.BackgroundVideoService;


@Controller
public class BackgroundVideoController {

	@Autowired
	BackgroundSpeakerService speakerService;
	
	@Autowired
	BackgroundCourseService  courseService;
	
	@Autowired
	BackgroundVideoService videoService;
	

	@RequestMapping("/videoShow.do")
	public ModelAndView videoShow(String page) {
		ModelAndView mv =new ModelAndView();
		List<Speaker> speaker = speakerService.selectAll();
		List<Course> course = courseService.selectAll();
		int count = videoService.selectAll().size();
		int pages = page==null|| page.equals("")?1:Integer.valueOf(page);
		List<Video> video = videoService.selectAllLimit((pages-1)*5, 5);
		mv.addObject("page", pages);
		mv.addObject("count", count);		
		mv.addObject("speaker", speaker);
		mv.addObject("course", course);
		mv.addObject("video", video);
		mv.setViewName("/background/BackgroundVideoShow");
		
		return mv;
		
	}

	@RequestMapping("/videoAddShow.do")
	public String videoAddShow(HttpServletRequest req) {
		List<Speaker> speaker = speakerService.selectAll();
		List<Course>  course = courseService.selectAll();
		req.setAttribute("speaker", speaker);
		req.setAttribute("course", course);
		
		return "background/BackgroundVideoAdd";

	}
	

	@RequestMapping("/videoAdd.do")
	public String videoAdd(Video video) {
    System.out.println(video);
		videoService.add(video);

		return "forward:/videoShow.do";	
	}
	
	@RequestMapping("/videoDelete.do")
	public void videoDelete(int id, HttpServletResponse resp) {

		videoService.delete(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@RequestMapping("/videoUpdateShow.do")
	public String speakerUpdateShow(int id,HttpServletRequest req) {
		Video video = videoService.selectById(id);
		System.out.println(video);
		List<Speaker> speaker = speakerService.selectAll();
		List<Course>  course = courseService.selectAll();
		req.setAttribute("speaker", speaker);
		req.setAttribute("course", course);
		req.setAttribute("video", video);
		return "/background/BackgroundVideoUpdate";

	}
	

	@RequestMapping("/videoUpdate.do")
	public String videoUpdate(Video video) {
	 
		videoService.update(video);

		return "forward:/videoShow.do";

	}
	
	
	@RequestMapping("/videoDeleteAll.do")
	public String deleteAll(String ids) {

		List<Integer> Array = JSON.parseArray(ids, Integer.class);
	    

		  
		videoService.deleteIn((ArrayList<Integer>)Array);	
		return "forward:/videoShow.do";

	}

	@RequestMapping("/videoSelectLike.do")
	public ModelAndView selectLike(String speakerId,String courseId, String factor, String page) {
		ModelAndView mv =new ModelAndView();
		List<Speaker> speaker = speakerService.selectAll();
		List<Course> course = courseService.selectAll();
		mv.addObject("speaker", speaker);
		mv.addObject("course", course);
		int count = videoService.selectLikeCount(speakerId, courseId, "title", factor);
		int pages = page==null|| page.equals("")?1:Integer.valueOf(page);
		mv.addObject("page", pages);
		mv.addObject("count", count);	
		mv.addObject("factor",factor);
		mv.addObject("speakerId", speakerId);
		mv.addObject("courseId", courseId);
		List<Video> video = videoService.selectLike(speakerId, courseId, "title", factor, (pages-1)*5, 5);

		mv.addObject("video", video);
		mv.setViewName("/background/BackgroundVideoShow");
		return mv;
	}
	

	
}
