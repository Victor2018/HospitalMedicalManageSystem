package com.haifeng.dao;

import com.haifeng.data.TableData;

public class PageModel {
	private int pageNum = 5;//每页显示的数据
	private int totalPage;// 总页数
	private int tableRow;//表的行数
	private int currentPage = 1;
	private TableData datas;
	private String tableName ;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
		tableRow = TableDataDao.get(tableName);
		totalPage = (int)Math.ceil(tableRow * 1.0/pageNum);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	public boolean isFirst(){
		return currentPage == 1;
	}
	
	public boolean isLast(){
		return currentPage == totalPage;
	}
	
	public boolean isPrev(){
		return currentPage > 1;
	}
	public boolean isNext(){
		return currentPage < totalPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		int startrow = (currentPage - 1) * pageNum + 1;
		int endrow = currentPage * pageNum;
		String sql = " select * from (select rownum num ,tn.* from " + tableName + " tn ) tname" +
		"  where tname.num >= " + startrow  + " and tname.num <=" + endrow;
		//System.out.println(sql);
		datas = TableDataDao.getAll(sql);
		
	}
	public TableData getDatas() {
		return datas;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTableRow() {
		return tableRow;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
}
