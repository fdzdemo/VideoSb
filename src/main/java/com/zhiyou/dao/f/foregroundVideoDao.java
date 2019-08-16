package com.zhiyou.dao.f;

import com.zhiyou.model.Video;

public interface foregroundVideoDao {

	Video selectById (Integer id);
	void update(Video vo);
}
