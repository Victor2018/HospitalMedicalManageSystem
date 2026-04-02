package com.haifeng.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.BLOB;

import com.haifeng.jdbc.ConnectionFactory;

public class PictureBlob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//write("E:\\n.rar");
		//read(1,"F:\\l.rar");//1 表示数据库中picture 表的 id
	}
	
	public static void write(String path){
		Connection con = ConnectionFactory.getConnection();
		try {
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(id) from picture");
			int maxid = 0;
			rs.next();
			maxid = rs.getInt(1);
			maxid++;
			st.executeUpdate("insert into picture values(" + maxid + ",empty_blob())");
			rs = st.executeQuery("select data from picture where id=" + maxid);
			rs.next();
			BLOB blob = (BLOB) rs.getObject(1);
			OutputStream os = blob.setBinaryStream(1024000);
			
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024000];
			int length = fis.read(buffer);
			while (length != -1){
				os.write(buffer, 0, length);
				length = fis.read(buffer);
			}
			fis.close();
			os.close();
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
	}
	
	public static void read(int id,String path){
		Connection con = ConnectionFactory.getConnection();
		try {
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select data from picture where id=" + id);
			rs.next();
			BLOB blob = (BLOB) rs.getObject(1);
			InputStream is = blob.getBinaryStream(1024000);
			
			File file = new File(path);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024000];
			int length = is.read(buffer);
			while (length != -1){
				fos.write(buffer,0,length);
				length = is.read(buffer);
			}
			is.close();
			fos.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
