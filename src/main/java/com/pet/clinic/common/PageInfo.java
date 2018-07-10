package com.pet.clinic.common;

import org.springframework.stereotype.Component;

/**
 * 分页对象
 * @author lixiejun
 *
 */
@Component
public class PageInfo {

	private int pageSize;    //每页大小
	
	private int currentPage; //当前页
	
	private int totalPage;   //总页数
	
	private int totalNum;    //总记录书

	public PageInfo() {
		super();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
		
}
