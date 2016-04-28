package com.myschool.form.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.myschool.form.dao.LoginDao;
import com.myschool.form.model.LoginForm;
//@Service("userService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDao loginDao;
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	@Override
	public LoginForm findById(Integer userId) {
		return loginDao.findById(userId);
	}

}
