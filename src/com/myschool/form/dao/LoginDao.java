package com.myschool.form.dao;

import com.myschool.form.model.LoginForm;

public interface LoginDao {
	LoginForm findById(Integer id);
}
