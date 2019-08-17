package com.zhiyou.service.impl.f;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.f.foregroundPersonalDao;
import com.zhiyou.model.User;
import com.zhiyou.service.f.foregroundPersonalService;

@Service
public class foregroundPersonalServiceImpl implements foregroundPersonalService {

	@Autowired
	foregroundPersonalDao dao;
	public User selectUserAllByIdAndName(String accounts,String password) {
		// TODO Auto-generated method stub
		return dao.selectUserAllByIdAndName(accounts, password) ;
	}
	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}
	@Override
	public User selectAllById(int id) {
		return dao.selectAllById(id);
		
	}
	@Override
	public User selectUserAllByPassword(String password) {
		// TODO Auto-generated method stub
		return dao.selectUserAllByPassword(password);
	}

}
