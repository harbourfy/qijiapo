package com.qjp.util.vo;

import java.util.List;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuTreeVO.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class BTreeVO {
	private Integer id;
	private String name;
	private String pid;
	private Integer nodeType; //1 公司 2.部门 3.用户 4. 菜单
    private List<BTreeVO> children;
    private String icon;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<BTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<BTreeVO> children) {
		this.children = children;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getNodeType() {
		return nodeType;
	}
	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}
}

