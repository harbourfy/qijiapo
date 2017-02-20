package com.qjp.util.api;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.qjp.base.url.CRMApiUrl;
import com.qjp.util.CommonUtils;
import com.qjp.util.HttpUtils;
import com.qjp.util.SHA1Utils;

/** 
 * <p>Project: qijiapo</p> 
 * <p>Title: CRMApiUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class CRMApiUtils {
	/**
	 * 获取CRM地址
	 * @return
	 */
	private static String getCRMUrl(){
		if(CommonUtils.getProdEnv()){
			return CRMApiUrl.crm;
		}else {
			return CRMApiUrl.crm ;
		}
	}
	
	
	public static String insertCustomer(String customer){
		String result = StringUtils.EMPTY;
		try {	
			String url = getCRMUrl() + CRMApiUrl.crm_insertCustomer;	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("customer", customer);
			Map<String,Object> maps = SHA1Utils.getSha1Map();
			maps.put("customer", customer);
			String secret = SHA1Utils.SHA1(maps);
			jsonObject.put("secret", secret);
			result = HttpUtils.postUrl(url, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

