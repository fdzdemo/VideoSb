package com.zhiyou.controller.s;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.s.BackgroundSpeakerService;

@Controller
public class BackgroundSpeakerController {
  
	@Autowired
	BackgroundSpeakerService speakerService;

	
	@RequestMapping("/speakerShow.do")
	public String speakerShow(HttpServletRequest req) {
		List<Speaker> list = speakerService.selectAll();
		req.setAttribute("list", list);
		return "background/BackgroundSpeakerShow";
		
	}
	
	
	@RequestMapping("/speakerDelete.do")
	public void speakerDelete(int id, HttpServletResponse resp) {

		speakerService.delete(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	@RequestMapping("/background/speakerAdd.do")
	public String speakerAdd(Speaker speaker) {
		speakerService.add(speaker);
		
		return "redirect:/speakerShow.do";	
	}

	@RequestMapping("/speakerUpdateShow.do")
	public String speakerUpdateShow(int id,HttpServletRequest req) {
		Speaker speaker = speakerService.SelectById(id);
		req.setAttribute("speaker", speaker);
		return "/background/BackgroundSpeakerUpdate";

	}

	@RequestMapping("/speakerUpdate.do")
	public String speakerUpdate(Speaker speaker) {
		speakerService.update(speaker);
		return "forward:/speakerShow.do";

	}

	@RequestMapping("/speakerDeleteAll.do")
	public String deleteAll(String ids) {

		List<Integer> Array = JSON.parseArray(ids, Integer.class);
	    

		  
		speakerService.deleteIn((ArrayList<Integer>)Array);	
		return "forward:/speakerShow.do";

	}
}
