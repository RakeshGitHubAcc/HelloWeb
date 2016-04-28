package com.myschool.form.model;

import java.sql.Date;

public class LoginForm extends MySchoolForm{
private Integer userId;
private String userName;
private String oldPswd;
private String newPswd;
private Date pswdEffectDate;
private Date pswdExpiryDate;
private Date createdDate;
private Date updatedDate;
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getOldPswd() {
	return oldPswd;
}
public void setOldPswd(String oldPswd) {
	this.oldPswd = oldPswd;
}
public String getNewPswd() {
	return newPswd;
}
public void setNewPswd(String newPswd) {
	this.newPswd = newPswd;
}
public Date getPswdEffectDate() {
	return pswdEffectDate;
}
public void setPswdEffectDate(Date pswdEffectDate) {
	this.pswdEffectDate = pswdEffectDate;
}
public Date getPswdExpiryDate() {
	return pswdExpiryDate;
}
public void setPswdExpiryDate(Date pswdExpiryDate) {
	this.pswdExpiryDate = pswdExpiryDate;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public Date getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}

}
