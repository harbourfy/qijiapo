package com.qjp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.qjp.base.VipLevel;
import com.qjp.entity.CompanyEntity;
import com.qjp.entity.ConfigEntity;
import com.qjp.entity.Constant;
import com.qjp.entity.UserEntity;
import com.qjp.service.CompanyService;
import com.qjp.service.ConfigService;
import com.qjp.util.LogUtils;
import com.qjp.util.UserUtils;
import com.qjp.util.query.CompanyQuery;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: CompanyController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/subList", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String subList(@ModelAttribute CompanyQuery companyQuery, HttpServletRequest request){
		String result = StringUtils.EMPTY;
		UserEntity user = UserUtils.getLoginUser(request);
		companyQuery.setCompanyId(user.getCompanyId().toString());
		companyQuery = companyService.getCompanyList(companyQuery);
		List<CompanyEntity> list = companyQuery.getItems();
		if(list != null && list.size() > 0){
			result = new Gson().toJson(list);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ModelAndView list(@ModelAttribute CompanyQuery companyQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/company/sub_company_list");
		UserEntity user = UserUtils.getLoginUser(request);
		companyQuery.setCompanyId(user.getCompanyId().toString());
		companyQuery = companyService.getCompanyList(companyQuery);
		mav.addObject("companyQuery", companyQuery);
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCompany(String id){
		ModelAndView mav = new ModelAndView("/company/sub_company_edit");
		CompanyEntity company = null;
		if(StringUtils.isNotBlank(id)){
			Long companyId = Long.parseLong(id);
			company = companyService.getCompanyById(companyId);
		}
		mav.addObject("company", company);
		
		return mav;
	}
	
	@RequestMapping(value = "/addSub", method = RequestMethod.GET)
	public ModelAndView addSubCompany(String id){
		ModelAndView mav = new ModelAndView("/company/company_addsub");
		CompanyEntity company = null;
		if(StringUtils.isNotBlank(id)){
			Long companyId = Long.parseLong(id);
			company = companyService.getCompanyById(companyId);
		}
		mav.addObject("company", company);
		
		return mav;
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdateCompany(@ModelAttribute CompanyEntity company, HttpServletRequest request){
		Integer result = 0;
		try{
			Long id = company.getId();
			UserEntity user = UserUtils.getLoginUser(request);
			if(id == null){
				company.setCreateUser(user.getUserName());
				company.setParentCompanyId(user.getCompanyId().toString());
				company.setParentCompanyName(user.getCompanyName());
				companyService.insertCompany(company);
				LogUtils.logAdmin("新增分公司信息：" + company.toLogString(), user);
				result = 1;
			}else{
				CompanyEntity oldCompany = companyService.getCompanyById(id);
				String oldCompanyStr = oldCompany.toLogString();
				oldCompany.setUpdateTime(new Date());
				oldCompany.setCompanyAddress(company.getCompanyAddress());
				oldCompany.setCompanyCeo(company.getCompanyCeo());
				oldCompany.setCompanyName(company.getCompanyName());
				oldCompany.setCompanySite(company.getCompanySite());
				oldCompany.setCompanyTelephone(company.getCompanyTelephone());
				oldCompany.setUpdateUser(user.getUserName());
				companyService.updateCompany(oldCompany);
				LogUtils.logAdmin("更新分公司信息,更新前：" + oldCompanyStr + "，更新后：" + oldCompany.toLogString(), user);
				result = 2;
			}
		}catch(Exception e){
			//暂时不记录监控
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public Integer deleteCompany(@ModelAttribute String id, HttpServletRequest request){
		Integer result = 0;
		if(StringUtils.isNotBlank(id)){
			companyService.deleteCompany(id);
			result = 1;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	@ResponseBody
	public Integer activateCompany(@ModelAttribute String id, HttpServletRequest request){
		Integer result = 0;
		if(StringUtils.isNotBlank(id)){
			companyService.activateCompany(id);
			result = 1;
		}
		
		return result;
	}
}

