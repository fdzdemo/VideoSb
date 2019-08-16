package com.zhiyou.controller.s;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;

import com.zhiyou.model.Course;

import com.zhiyou.service.s.BackgroundCourseService;

//@RestController
@Controller
public class BackgroundCourseController {
	@Autowired
	BackgroundCourseService courseService;
	
	
	@RequestMapping("showCourseH.do")
	protected String showCourseH(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		int count=courseService.selectCount();
		String pages=req.getParameter("page");
		int page=(pages==null||pages.equals(" ")?1:Integer.valueOf(pages));
		req.setAttribute("page", page);
		req.setAttribute("count", count);
		
		PageHelper.startPage(page,5);
		req.setAttribute("list", courseService.selectAllPage());
//		req.setAttribute("list", adminService.selectAllPage((page-1)*5, 5));

//		req.getRequestDispatcher("/background/BackgroundCourseShow.jsp").forward(req, resp);
		return "/background/BackgroundCourseShow";
	}
	@RequestMapping("addCourseShow.do")
	public String addCaouseShow() {
		return "/background/BackgroundCourseAdd";
	}
	@RequestMapping("addCourse.do")
	public void addCourse(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String course_title =req.getParameter("course_title");
		String course_desc=req.getParameter("course_desc");
		String subject_id=req.getParameter("subject_id");
		Course course =new Course(course_title,course_desc,Integer.valueOf(subject_id));
		courseService.add(course);
		resp.sendRedirect("showCourseH.do");
	}
	
	@RequestMapping("courseDeleteAll.do")
	public String deleteAll(String ids) {
		List<Integer> Array = JSON.parseArray(ids, Integer.class);
	    
		/* for (Integer integer : Array) { 
			  
			  System.out.println(integer); 
			  
		  
		  }*/
		  
		courseService.deleteMany((ArrayList<Integer>)Array);	
		return "forward:showCourseH.do";

	}
	
	@RequestMapping("delCourse.do")
	public void delCourse(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String id =req.getParameter("id");
		Course selectOne = courseService.selectOne(Integer.valueOf(id));
		if(selectOne!=null) {
			resp.getWriter().write("success");
			courseService.delete(Integer.valueOf(id));
		}		

	}
	@RequestMapping("updateCourse.do")
	public String updateCourse(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String id =req.getParameter("id");
		Course selectOne = courseService.selectOne(Integer.valueOf(id));
		req.setAttribute("course",selectOne);
//		req.getRequestDispatcher("/updateCourse.jsp").forward(req, resp);
		return "/background/BackgroundCourseUpdate";
	}
	
	@RequestMapping("alertCourse.do")
	public void alertCourse(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String id =req.getParameter("id");
		String course_title = req.getParameter("course_title");
		String course_desc = req.getParameter("course_desc");
		String subject_id = req.getParameter("subject_id");
		Course course = new Course(Integer.valueOf(id),course_title,course_desc,Integer.valueOf(subject_id));
		courseService.update(course);
		resp.sendRedirect("showCourseH.do");
	}
	
	
	
	
}
