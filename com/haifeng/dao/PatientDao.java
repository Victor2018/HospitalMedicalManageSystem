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
import com.haifeng.data.Patient;
import com.haifeng.jdbc.ConnectionFactory;

public class PatientDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patient p = new Patient();
		
		/*p.setPid(1009);
		p.setName("423099");
		p.setSex('男');
		p.setAge(22);
		p.setNation("土家族");
		p.setSid("450623198903066235");
		p.setWid(110);
		p.setPdate("20130202");
		
		
		update(p);*/
		
		/*List<Patient> pats = getAll("select * from patient");
		for (Patient p: pats){
			System.out.println(p.getPid() + "-" + p.getName() + "-" + p.getSex() + "-" + p.getAge() + "-" + p.getNation()+ "-" + p.getSid() + "-" + p.getWid() + "-" + p.getPdate());
		}*/
	}
	
	public static List<Patient> getAll(String sql){//调用数据库中的pat_pack.get_pats
		List<Patient> datas = new ArrayList<Patient>();
		Connection con = ConnectionFactory.getConnection();
		try {
			CallableStatement cs = con.prepareCall("{call pat_pack.get_pats(?)}");//调用存储过程返回结果集
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while (rs.next()){
				Patient pat = new Patient();
				pat.setPid(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setSex(rs.getString(3).charAt(0));
				pat.setAge(rs.getInt(4));
				pat.setNation(rs.getString(5));
				pat.setSid(rs.getString(6));
				pat.setWid(rs.getInt(7));
				pat.setPdate(rs.getString(8));
				datas.add(pat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datas;
	}
	
	
	
	/*public static List<Patient> getAll(String sql){
		List<Patient> datas = new ArrayList<Patient>();
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				Patient pat = new Patient();
				pat.setPid(rs.getInt(1));
				pat.setName(rs.getString(2));
				pat.setSex(rs.getString(3).charAt(0));
				pat.setAge(rs.getInt(4));
				pat.setNation(rs.getString(5));
				pat.setSid(rs.getString(6));
				pat.setWid(rs.getInt(7));
				pat.setPdate(rs.getString(8));
				datas.add(pat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(con);
		}
		return datas;
		
	}*/
	
	public static void Look(Patient patient){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from patient where pid=?");
			ps.setObject(1, patient.getPid());
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
	
	
	
	public static void add(Patient patient){//优化后----调用数据库中的存储过程
		Connection con = ConnectionFactory.getConnection();
		try {
			CallableStatement cs = con.prepareCall("{call add_patient(?,?,?,?,?,?,?)}");
			cs.setString(1, patient.getName());
			cs.setString(2, patient.getSex() + "");
			cs.setObject(3, patient.getAge());
			cs.setString(4, patient.getNation());
			cs.setString(5, patient.getSid());
			cs.setObject(6, patient.getWid());
			cs.setString(7, patient.getPdate());
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
	
	
	public static void delete(Patient patient){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from patient  where pid=?");
		
			ps.setObject(1, patient.getPid());
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
	
	
	
	public static void update(Patient patient){
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update patient set name=?,sex=?,age=?,nation=?,sid=?,wid=?,pdate=? where pid=?");
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getSex() +"");
			ps.setObject(3, patient.getAge());
			ps.setString(4, patient.getNation());
			ps.setString(5, patient.getSid());
			ps.setObject(6, patient.getWid());
			ps.setString(7, patient.getPdate());
			ps.setObject(8, patient.getPid());
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
