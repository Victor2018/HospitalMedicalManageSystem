package com.haifeng.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class YongHuSheZhi extends JFrame {

	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YongHuSheZhi yhsz = new YongHuSheZhi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		yhsz.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		yhsz.setVisible(true);
		yhsz.setResizable(false);
		yhsz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public YongHuSheZhi() {
		super();
		getContentPane().setLayout(null);
		this.setTitle("用户设置");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file1 = new JMenu("用户管理");
		JMenu file2 = new JMenu("用户权限管理");
		JMenu file3 = new JMenu("用户组管理");
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
		
		
		JMenuItem xjyh = new JMenuItem("新建用户");
		xjyh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}});
		JMenuItem xgyh = new JMenuItem("修改用户");
		JMenuItem scyh = new JMenuItem("删除用户");
		JMenuItem ckyhxx = new JMenuItem("查看用户信息");
		JMenuItem qcyhmm = new JMenuItem("清除用户密码");
		file1.add(xjyh);
		file1.add(xgyh);
		file1.add(scyh);
		file1.add(ckyhxx);
		file1.add(qcyhmm);
		
		JMenuItem jyhzsqgyh = new JMenuItem("A.将用户组授权给用户");
		JMenuItem zjgyhsq = new JMenuItem("B.直接给用户授权");
		file2.add(jyhzsqgyh);
		file2.add(zjgyhsq);
		
		JMenuItem zjyhz = new JMenuItem("增加用户组");
		JMenuItem xgyhz = new JMenuItem("修改用户组");
		JMenuItem scyhz = new JMenuItem("删除用户组");
		file3.add(zjyhz);
		file3.add(xgyhz);
		file3.add(scyhz);

	
	}

}
