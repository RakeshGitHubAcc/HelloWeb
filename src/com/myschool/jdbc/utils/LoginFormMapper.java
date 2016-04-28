package com.myschool.jdbc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myschool.form.model.LoginForm;

public class LoginFormMapper implements RowMapper<LoginForm> {

	@Override
	public LoginForm mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginForm loginForm = new LoginForm();
		loginForm.setUserId(rs.getInt("userId"));
		loginForm.setUserName(rs.getString("userName"));
		loginForm.setOldPswd(rs.getString("oldPswd"));
		loginForm.setNewPswd(rs.getString("newPswd"));
		loginForm.setPswdEffectDate(rs.getDate("pswdEffectDate"));
		loginForm.setPswdExpiryDate(rs.getDate("pswdExpiryDate"));
		loginForm.setCreatedDate(rs.getDate("createdDate"));
		loginForm.setUpdatedDate(rs.getDate("updatedDate"));
		return loginForm;
	}

}
