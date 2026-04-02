package com.haifeng.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

import com.haifeng.data.Doctor;
import com.haifeng.jdbc.ConnectionFactory;

public class DoctorDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor d = new Doctor();
		//d.setDid(107);
		
		
		//Look(d);
	/*	d.setName("张海锋");
		d.setPassword("X423099");
		d.setSex('女');
		d.setAge(21);
		d.setPhone("15971020806");
		d.setMail("815449243@qq.com");
		d.setAddress("湖北");
		update(d);*/
		
		/*List<Doctor> docs = getAll("select * from doctor");
		for (Doctor d: docs){
			System.out.println(d.getDid() + "" + d.getName() + "-" + d.getPassword() + "-"+ d.getSex() + "-" + d.getAge() + "-"+ d.getPhone() + "-" + d.getMail() + "-" + d.getAddress());
		}*/
		
	}
	
	/*public static List<Doctor> getAll(String sql){//调用数据库中的doc_pack.get_docs
		List<Doctor> datas = new ArrayList<Doctor>();
		Connection con = ConnectionFactory.getConnection();
		try {
			CallableStatement cs = con.prepareCall("{call doc_pack.get_docs(?)}");//调用存储过程返回结果集
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while (rs.next()){
				Doctor doc = new Doctor();
				doc.setDid(rs.getInt(1));
				doc.setName(rs.getString(2));
				doc.setPassword(rs.getString(3));
				doc.setSex(rs.getString(4).charAt(0));
				doc.setAge(rs.getInt(5));
				doc.setPhone(rs.getString(6));
				doc.setMail(rs.getString(7));
				doc.setAddress(rs.getString(8));
				datas.add(doc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datas;
	}*/
	
	
	
	
	public static List<Doctor> getAll(String sql){
		List<Doctor> datas = new ArrayList<Doctor>();
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				Doctor doc = new Doctor();
				doc.setDid(rs.getInt(1));
				doc.setName(rs.getString(2));
				doc.setSex(rs.getString(3).charAt(0));
				doc.setAge(rs.getInt(4));
				doc.setPhone(rs.getString(5));
				doc.setMail(rs.getString(6));
				doc.setAddress(rs.getString(7));
				datas.add(doc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return datas;
		
	}
	
	public static void Look(Doctor doctor){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from doctor where did=?");
			ps.setObject(1, doctor.getDid());
			ps.executeUpdate();
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
		}finally {
			ConnectionFactory.close(con);
		}
		
	} 
	
	
	
	public static void add(Doctor doctor){//优化后----调用数据库中的存储过程
		Connection con = ConnectionFactory.getConnection();
		try {
			CallableStatement cs = con.prepareCall("{call add_doctor(?,?,?,?,?,?,?)}");
			cs.setString(1, doctor.getName());
			cs.setString(2, doctor.getPassword());
			cs.setString(3, doctor.getSex() + "");
			cs.setObject(4, doctor.getAge());
			cs.setString(5, doctor.getPhone());
			cs.setString(6, doctor.getMail());
			cs.setString(7, doctor.getAddress());
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.close(con);
		}
	}
	/*public static void add(Doctor doctor){//优化前
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, doctor.getDid());
			ps.setString(2, doctor.getName());
			ps.setString(3, doctor.getSex() + "");
			ps.setInt(4, doctor.getAge());
			ps.setString(5, doctor.getPhone());
			ps.setString(6, doctor.getMail());
			ps.setString(7, doctor.getAddress());
			ps.executeUpdate();
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
		}finally {
			ConnectionFactory.close(con);
		}
		
	} */
	
	

	
	
	
	public static void delete(Doctor doctor){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from doctor  where did=?");
		
			ps.setObject(1, doctor.getDid());
			ps.executeUpdate();
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
		}finally {
			ConnectionFactory.close(con);
		}
		
	} 
	
	
	
	public static void update(Doctor doctor){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update doctor set name=?,password=?,sex=?,age=?,phone=?,mail=?,address=? where did=?");
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getPassword());
			ps.setString(3, doctor.getSex() + "");
			ps.setObject(4, doctor.getAge());
			ps.setString(5, doctor.getPhone());
			ps.setString(6, doctor.getMail());
			ps.setString(7, doctor.getAddress());
			ps.setObject(8, doctor.getDid());
			ps.executeUpdate();
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
		}finally {
			ConnectionFactory.close(con);
		}
		
	} 
	

}
