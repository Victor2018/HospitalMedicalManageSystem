package com.haifeng.data;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	private TableData datas;
	
	public MyTableModel(TableData datas){
		this.datas = datas;
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return datas.getColumns().size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.getDatas().size();
	}
	public Object[] getRow(int row){
		return datas.getDatas().get(row);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datas.getDatas().get(rowIndex)[columnIndex];
	}
	 public String getColumnName(int column) { 
		 return datas.getColumns().get(column); 
	 }
	 public boolean isCellEditable(int row, int column) { return true; }

	}
