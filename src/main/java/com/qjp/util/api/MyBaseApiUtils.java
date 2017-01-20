package com.qjp.util.api;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.qjp.base.url.MyBaseApiUrl;
import com.qjp.util.CommonUtils;
import com.qjp.util.HttpUtils;
import com.qjp.util.SHA1Utils;

/** 
 * <p>Project: qijiapo</p> 
 * <p>Title: MyBaseApiUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class MyBaseApiUtils {
	/**
	 * 获取Mybase地址
	 * @return
	 */
	private static String getMyBaseUrl(){
		if(CommonUtils.getProdEnv()){
			return MyBaseApiUrl.mybase;
		}else {
			return MyBaseApiUrl.mybase ;
		}
	}
	
	
	public static String login(String account, String password){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_login;	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("account", account);
			jsonObject.put("password", password);
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("account", account);
			maps.put("password", password);
			String secret = SHA1Utils.SHA1(maps);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 获取子公司信息列表
	 * @param companyId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public static String getSubCompanyPage(String companyName, String companyId, String pageSize, String currentPage){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getSubCompanyPage;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", companyId);
			maps.put("pageSize", pageSize);
			maps.put("currentPage", currentPage);
			maps.put("companyName", companyName);
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", companyId);
			jsonObject.put("pageSize", pageSize);
			jsonObject.put("currentPage",currentPage);
			jsonObject.put("companyName",companyName);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 获取子公司信息列表
	 * @param companyId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public static String insertCompany(String companyJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_insertCompany;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyJson", companyJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyJson", companyJson);
			jsonObject.put("secret", secret);
			HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 更新公司信息
	 * @param companyJson
	 * @return
	 */
	public static String updateCompany(String companyJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_updateCompany;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyJson", companyJson);
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyJson", companyJson);
			jsonObject.put("secret", secret);
			HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 禁用子公司信息
	 * @param id
	 * @return
	 */
	public static String deleteCompany(String id){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_close;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", id);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("secret", secret);
			HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 激活子公司信息
	 * @param id
	 * @return
	 */
	public static String activateCompany(String id){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_activate;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", id);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("secret", secret);
			HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 记录日志
	 * @param id
	 * @return
	 */
	public static String log(String logJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_log;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("logJson", logJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("logJson", logJson);
			jsonObject.put("secret", secret);
			HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 记录日志
	 * @param id
	 * @return
	 */
	public static String getAdminLogs(String companyId, String pageSize, String currentPage){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getAdminLogs;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyId", companyId);
			maps.put("pageSize", pageSize);
			maps.put("currentPage", currentPage);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyId", companyId);
			jsonObject.put("pageSize", pageSize);
			jsonObject.put("currentPage", currentPage);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 获取菜单
	 * @param id
	 * @return
	 */
	public static String getMenus(String userId){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getMenus;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("userId", userId);			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userId", userId);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据公司id获取公司信息
	 * @param id
	 * @return
	 */
	public static String getCompanyById(String id){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getCompanyById;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", id);			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 记录日志
	 * @param id
	 * @return
	 */
	public static String getDepartmentByCompanyId(String id){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getDepByCompanyId;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", id);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getUserPage(String status, String companyId, String departmentId, String pageSize, String currentPage){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getUserPage;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyId", companyId);
			maps.put("departmentId", departmentId);
			maps.put("pageSize", pageSize);
			maps.put("status", status);
			maps.put("currentPage", currentPage);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyId", companyId);
			jsonObject.put("departmentId", departmentId);
			jsonObject.put("pageSize", pageSize);
			jsonObject.put("currentPage", currentPage);
			jsonObject.put("secret", secret);
			jsonObject.put("status", status);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 获取子公司信息列表
	 * @param companyId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public static String getCompanyStaffTreeById(String companyId){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getCompanyStaffTreeById;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyId", companyId);
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyId", companyId);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 是否存在相同部门
	 * @param id
	 * @param departmentName
	 * @param isCompany
	 * @return
	 */
	public static String isExistDepartment(String id, String departmentName, String isCompany){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_isExistDepartment;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("departmentName", departmentName);
			maps.put("id", id);
			maps.put("isCompany", isCompany);
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("departmentName", departmentName);
			jsonObject.put("id", id);
			jsonObject.put("isCompany", isCompany);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 新增部门
	 * @param departmentJson
	 * @return
	 */
	public static String insertDepartment(String departmentJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_insertDepartment;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("departmentJson", departmentJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("departmentJson", departmentJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 更新公司信息
	 * @param companyJson
	 * @return
	 */
	public static String updateDepartment(String departmentJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_updateDepartment;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("departmentJson", departmentJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("departmentJson", departmentJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static String insertUser(String userJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_insertUser;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("userJson", userJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userJson", userJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 更新员工信息
	 * @param companyJson
	 * @return
	 */
	public static String updateUser(String userJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_updateUser;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("userJson", userJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userJson", userJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getDepById(String id){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getDepById;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("id", id);			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", id);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getSystemPosition(){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getSystemPosition;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getPositionByCompanyId(String companyId){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_getPositionByCompanyId;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyId", companyId);			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyId", companyId);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String isExistPosition(String companyId, String positionName){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_isExistPosition;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("companyId", companyId);		
			maps.put("positionName", positionName);
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("companyId", companyId);
			jsonObject.put("positionName", positionName);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	public static String updatePosition(String positionJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_updatePosition;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("positionJson", positionJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("positionJson", positionJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String insertPosition(String positionJson){
		String result = StringUtils.EMPTY;
		try {	
			String url = getMyBaseUrl() + MyBaseApiUrl.mybase_insertPosition;
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("positionJson", positionJson);
			
			String secret = SHA1Utils.SHA1(maps);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("positionJson", positionJson);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

