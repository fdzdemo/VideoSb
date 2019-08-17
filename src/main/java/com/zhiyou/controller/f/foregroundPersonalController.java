package com.zhiyou.controller.f;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.f.foregroundPersonalService;

@Controller
public class foregroundPersonalController {

	@Autowired
	foregroundPersonalService fo;
	//个人中心回显
	@RequestMapping("/selectUser.do")
	public String selectUser(String accounts,String password,HttpServletRequest req) {
		User user = fo.selectUserAllByIdAndName(accounts, password);
		if (user==null) {
			req.setAttribute("msg","没有此账户");
			return "/index";
		}else {
			req.setAttribute("user", user);
			req.getSession().setAttribute("user", user);
			System.out.println(user);
		}

		return "/foreground/PersonalCenter";

	}

	//跳更改头像页面
	@RequestMapping("/avatarUpload.do")
	public String AvatarUpload() {

		return "foreground/AvatarUpload";

	}

	//跳更改密码页面
	@RequestMapping("/passwordUpdate.do")
	public String PasswordUpdate() {

		return "foreground/PasswordUpdate";

	}


	//退出
	@RequestMapping("/loginOut.do")
	public String TuiUser(String accounts,String password,HttpServletRequest req) {
		req.getSession().invalidate();

		return "redirect:/index.jsp";
		//resp.sendRedirect("showCourseH.do");
	}

	//资料回显
	@RequestMapping("/userUpadteShow.do")
	public String UserUpadteShow(HttpServletRequest req) {

		return "/foreground/UserUpdate";
		//resp.sendRedirect("showCourseH.do");
	}

	//更改资料
	@RequestMapping("/userUpadte.do")
	public String UserUpadte(User user,HttpServletRequest req) {
		fo.updateUser(user);
		User user1 = (User)req.getSession().getAttribute("user");
		System.out.println(user1);
		int id = user1.getId();
		User user2 = fo.selectAllById(id);
		req.getSession().setAttribute("user", user2);
		System.out.println(user2);
		System.out.println(111);
		return "/foreground/PersonalCenter";

	}
	//旧密码验证
	@RequestMapping("/findUsername.do")
	public void FindPassword(HttpServletRequest req,HttpServletResponse res) throws Exception, JsonMappingException, IOException {
		String string = req.getParameter("password");
		User user1 = (User)req.getSession().getAttribute("user");
		String password2 = user1.getPassword();
		System.out.println(password2);
		res.setContentType("text/html;charset=utf-8");
		Map<String,Object> map=new HashMap<String,Object>();
		if(password2.equals(string)) {
			map.put("userExsit", true);
			map.put("msg", "密码正确");
		}else {

			map.put("userExsit", false);
			map.put("msg", "密码错误");
		}

		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(res.getWriter(), map);

	}

	//两次密码对比
	@RequestMapping("/rePasswordCheck.do")
	public void RePasswordCheck(HttpServletRequest req,HttpServletResponse res) throws Exception, JsonMappingException, IOException {
		String string1 = req.getParameter("rePassword");
		String string2 = req.getParameter("newPassword");
		Map<String,Object> map=new HashMap<String,Object>();
		if(string2.equals(string1)) {
			map.put("isSuccess", true);
		}else {
			map.put("isSuccess", false);
		}
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(res.getWriter(), map);
	}


	//更改密码成功
	@RequestMapping("/passwordUpdate1.do")
	public String passwordUpdate1(HttpServletRequest req) {
		String string1 = req.getParameter("rePassword");
		String string2 = req.getParameter("newPassword");
		if(string2.equals(string1)) {
			User user1 = (User)req.getSession().getAttribute("user");
			System.out.println(user1);
			int id = user1.getId();
			User user=new User();
			user.setId(id);
			user.setPassword(string2);
			fo.updateUser(user);
			User user2 = fo.selectAllById(id);
			req.getSession().setAttribute("user", user2);
			return "/foreground/PersonalCenter";
		}else {
			return "/foreground/PasswordUpdate";
		}
	}
	
	//更换头像
		@RequestMapping("/uploadAvatar.do")
		public String UploadAvatar(@RequestParam("imageFile")MultipartFile photo,HttpServletRequest req) throws Exception {
			String idd = req.getParameter("idd");
			//确定上传路径（服务器里）
			//获取服务器路径
			String path = req.getServletContext().getRealPath("img1");//服务器根下面的upload
			//建立这个目录
			File file=new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
			//获取文件名字
			String fileName=new Date().getTime()+ photo.getOriginalFilename();
			System.out.println(fileName);
			//确定上传路径
			 String fileNa="img1/"+fileName;
			 System.out.println(fileNa);
		
			User user1=new User();
			user1.setId(Integer.valueOf(idd));
			user1.setImgurl(fileNa);
			fo.updateUser(user1);
			File descFile=new File(file, fileName);
			
			//文件上传											//目标路径  数据
			org.apache.commons.io.FileUtils.writeByteArrayToFile(descFile, photo.getBytes());
			User user = (User)req.getSession().getAttribute("user");
			
			User user2 = fo.selectAllById(Integer.valueOf(idd));
			req.getSession().setAttribute("user", user2);
			
			
			
			//吧路径传到页面
			req.getSession().setAttribute("img", "/img1/"+fileName);
			//req.setAttribute("img", "/img1/"+fileName);
			return "/foreground/PersonalCenter";
			
		}




}
