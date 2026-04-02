package com.haifeng.data;

import java.util.List;

public class TableData {
	private List<Object[]> datas;
	private List<String> columns;
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<Object[]> getDatas() {
		return datas;
	}
	public void setDatas(List<Object[]> datas) {
		this.datas = datas;
	}

}
