package com.zhiyou.service.f;

import com.zhiyou.model.User;

public interface foregroundPersonalService {

	User selectUserAllByIdAndName(String accounts,String password);
	void updateUser(User user);
	User selectAllById(int id);
	User selectUserAllByPassword(String password);
}
