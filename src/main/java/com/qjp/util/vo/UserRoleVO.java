package com.qjp.util.vo;

import com.qjp.entity.BaseEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserEntity.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class UserRoleVO extends BaseEntity{
	private Long companyId;
	private String companyName;
	private Integer departmentId;
	private String departmentName;
	private Integer status;
	private String userName;
	private String telphone;
	private String password;
	private String mobile;
	private String userCode;
	private Integer isLoginMybase;
	private Integer positionId;
	private String positionName;
	private String email;
	private Integer roleUserId;
	private Integer menuDefinedType;
	
	public Integer getMenuDefinedType() {
		return menuDefinedType;
	}
	public void setMenuDefinedType(Integer menuDefinedType) {
		this.menuDefinedType = menuDefinedType;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Integer getIsLoginMybase() {
		return isLoginMybase;
	}
	public void setIsLoginMybase(Integer isLoginMybase) {
		this.isLoginMybase = isLoginMybase;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoleUserId() {
		return roleUserId;
	}
	public void setRoleUserId(Integer roleUserId) {
		this.roleUserId = roleUserId;
	}
	
	
}

