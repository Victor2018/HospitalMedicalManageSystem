package com.haifeng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.haifeng.data.TableData;
import com.haifeng.jdbc.ConnectionFactory;


public class TableDataDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableData td = getAll("emp");
		for (String n : td.getColumns()) {
			System.out.print(n + "       ");
		}
		System.out.println();
		
		for (Object[] d : td.getDatas()) {
			for (Object o : d) {
				System.out.print(o + "  ");
			}
			System.out.println();
		}
	}
	
	public static int get(String tableName){
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(" select count(1) from " + tableName);
			rs.next();
			rows = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	public static TableData getAll(String sql){
		TableData td = new TableData();
		Connection con = ConnectionFactory.getConnection();
		
		try{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				ResultSetMetaData rsmd =  rs.getMetaData();
				int colNum = rsmd.getColumnCount();
				List<String> coldatas = new ArrayList<String>();
				for (int c = 1; c <= colNum; c++) {
					coldatas.add(rsmd.getColumnName(c));
				}
				
				List<Object[]> rowsData = new ArrayList<Object[]>();
				while (rs.next()) {
					Object[] rowData = new Object[colNum];
					for (int i = 1; i <= colNum;i++) {
						rowData[i - 1] = rs.getObject(i);
					}
					rowsData.add(rowData);
				}
				td.setColumns(coldatas);
				td.setDatas(rowsData);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally {
				ConnectionFactory.close(con);
			}
			return td;
	}


}
