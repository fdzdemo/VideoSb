package com.zhiyou.service.f;

import com.zhiyou.model.Video;

public interface foregroundVideoService {


	Video selectById (Integer id);
	void update(Video vo);
}
