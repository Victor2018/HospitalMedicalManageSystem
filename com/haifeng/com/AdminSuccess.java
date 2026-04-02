package com.haifeng.com;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFormattedTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;

import com.haifeng.dao.DoctorDao;
import com.haifeng.dao.DoctorPageModel;
import com.haifeng.data.Doctor;
import com.haifeng.jdbc.ConnectionFactory;
import com.swtdesigner.SwingResourceManager;

public class AdminSuccess extends JFrame {
	private DoctorPageModel dpm = new DoctorPageModel();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminSuccess as = new AdminSuccess();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		as.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		as.setVisible(true);
		as.setResizable(false);
		as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public AdminSuccess() {
		super();
		this.setTitle("管理员登录成功！");
		getContentPane().setLayout(null);
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		final JMenu file1 = new JMenu("系统管理");
		final JMenu file2 = new JMenu("注册用户");
		final JMenu file3 = new JMenu("信息查询平台");
		final JMenu file4 = new JMenu("基金征集");
		final JMenu file5 = new JMenu("费用结算");
		final JMenu file6 = new JMenu("医疗监督");
		final JMenu file7 = new JMenu("统计报表");
		final JMenu file8 = new JMenu("系统登陆");
		
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
		jmb.add(file4);
		jmb.add(file5);
		jmb.add(file6);
		jmb.add(file7);
		jmb.add(file8);
		
		JMenuItem yhsz = new JMenuItem("用户设置");
		
		JMenuItem zccssz = new JMenuItem("政策参数设置");
		
		JMenuItem icksz = new JMenuItem("IC卡设置");
		
		JMenuItem sjkgl = new JMenuItem("数据库管理");
		
		JMenuItem xtjk = new JMenuItem("系统监控");
		
		JMenuItem xtsz = new JMenuItem("系统设置");
		
		JMenuItem xtsj = new JMenuItem("系统升级");
		
		JMenuItem xtgl = new JMenuItem("系统管理");
		JMenuItem bzts = new JMenuItem("帮助提示");
		
		
		file1.add(yhsz);
		file1.add(zccssz);
		file1.add(icksz);
		file1.add(sjkgl);
		file1.add(xtjk);
		file1.add(xtsz);
		file1.add(xtsj);
		file1.add(xtgl);
		file1.add(bzts);
		
		JMenuItem ptregist = new JMenuItem("普通用户注册");
		JMenuItem adminregist = new JMenuItem("管理员注册");
		
		file2.add(ptregist);
		file2.add(adminregist);
		
		JMenuItem doctor = new JMenuItem("医生信息查询（D）");
		JMenuItem patient = new JMenuItem("病人信息查询（P）");
		
		file3.add(doctor);
		file3.add(patient);
		
			doctor.addActionListener(new ActionListener(){
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DoctorMessageLook aregist = new DoctorMessageLook();
					Toolkit tool = Toolkit.getDefaultToolkit();
					Dimension d = tool.getScreenSize();
					aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
					aregist.setVisible(true);
					aregist.setResizable(false);;
				}});
		
			patient.addActionListener(new ActionListener(){
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PatientMessageLook aregist = new PatientMessageLook();
					Toolkit tool = Toolkit.getDefaultToolkit();
					Dimension d = tool.getScreenSize();
					aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
					aregist.setVisible(true);
					aregist.setResizable(false);
					
				}});
		
		ptregist.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Regist regist = new Regist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				regist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				regist.setVisible(true);
				regist.setResizable(false);
				
			}});
		
		adminregist.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminRegist aregist = new AdminRegist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				aregist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				aregist.setVisible(true);
				aregist.setResizable(false);
			}});
		
		
		JMenuItem ptyhdl = new JMenuItem("普通用户登陆");
		ptyhdl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Hello dl = new Hello();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				dl.setBounds((d.width-380)/2, (d.height-280)/2, 380, 280);
				dl.setVisible(true);
				dl.setResizable(false);
				
				file1.setEnabled(true);
				file2.setEnabled(true);
				file3.setEnabled(true);
				file4.setEnabled(true);
				file5.setEnabled(true);
				file6.setEnabled(true);
				file7.setEnabled(true);
				file8.setEnabled(true);
				
			}});
		JMenuItem glydl = new JMenuItem("管理员登陆（已登陆）");
		glydl.setEnabled(false);
		JMenuItem tcxt = new JMenuItem("退出系统");
		tcxt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int jop = JOptionPane.showConfirmDialog(AdminSuccess.this, "是否确定退出系统?");
				if (jop == 0){
					System.exit(0);
					AdminSuccess.this.dispose();
				}
				
			}});
		file8.add(ptyhdl);
		file8.add(glydl);
		file8.add(tcxt);
		
		JMenuItem dc = new JMenuItem("总计查询");
		dc.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  // String name = "doctor";
					
				//String tablename = "doctor";
				Connection conn = null; // 声明数据连接对象
				Statement st = null; // 声明Statement对象
				ResultSet rs = null; // 声明结果集对象
				conn = ConnectionFactory.getConnection(); // 建立数据连接
				try {
					st = conn.createStatement();
					rs = st.executeQuery("select count(1) from doctor");
					if (rs.next()){
						int row = dpm.getTableRow();
						Doctor d = new Doctor();
						d.setRow(row);
						
						
						
						DoctorCount doc = new DoctorCount(d);
						Toolkit tool = Toolkit.getDefaultToolkit();
						Dimension d1 = tool.getScreenSize();
						doc.setBounds((d1.width-400)/2, (d1.height-300)/2, 400, 300);
						doc.setVisible(true);
						doc.setResizable(false);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				
				
			}});
		
		file7.add(dc);

		final JLabel label = new JLabel();
		label.setIcon(SwingResourceManager.getIcon(AdminSuccess.class, "/pictures/doctormessage.jpg"));
		label.setBounds(0, 0, 600, 480);
		getContentPane().add(label);
	}

}
