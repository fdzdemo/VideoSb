package com.zhiyou.dao.f;

import org.springframework.stereotype.Repository;

import com.zhiyou.model.Video;
@Repository
public interface foregroundVideoDao {

	Video selectById (Integer id);
	void update(Video vo);
}
