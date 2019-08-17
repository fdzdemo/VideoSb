package com.zhiyou.dao.f;

import com.zhiyou.model.User;

public interface foregroundPersonalDao {

	User selectUserAllByIdAndName(String accounts,String password);
	void updateUser(User user);
	User selectAllById(int id);
	User selectUserAllByPassword(String password);
}
