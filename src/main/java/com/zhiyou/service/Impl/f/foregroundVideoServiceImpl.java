package com.zhiyou.service.Impl.f;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.f.foregroundVideoDao;
import com.zhiyou.model.Video;
import com.zhiyou.service.f.foregroundVideoService;
@Service
public class foregroundVideoServiceImpl implements foregroundVideoService {

	@Autowired
	foregroundVideoDao voo;
	public Video selectById(Integer id) {
		
		return voo.selectById(id);
	}

	public void update(Video vo) {
		
		voo.update(vo);
	}

}
