package com.liangx.service;

import java.util.List;

import com.liangx.bean.User;

public interface UserDao {
	public int addUser(User user);
	
	public User getUser(String userName);
	
	public List getAllUser();
}
