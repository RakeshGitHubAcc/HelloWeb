package com.myschool.form.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.myschool.form.model.LoginForm;
import com.myschool.jdbc.utils.LoginFormMapper;
//@Repository
public class LoginDaoImpl implements LoginDao {
	private DataSource dataSource;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				this.dataSource);
	}

	@Override
	public LoginForm findById(Integer userId) {
		 String SQL = "SELECT * FROM userlogin WHERE userId = :userId";  
		 SqlParameterSource namedParameters = new MapSqlParameterSource("userId", Integer.valueOf(userId));  
		 LoginForm employee = (LoginForm) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new LoginFormMapper());  
		 return employee; 
	}
}
