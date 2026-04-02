package com.haifeng.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JFrame;

public class XiTongJianKong extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiTongJianKong xtjk = new XiTongJianKong();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		xtjk.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		xtjk.setVisible(true);
		xtjk.setResizable(false);
		xtjk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public XiTongJianKong() {
		super();
		getContentPane().setLayout(null);
		
		this.setTitle("系统监控");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file1 = new JMenu("用户监控");
		JMenu file2 = new JMenu("定点医疗机构监控");
		JMenu file3 = new JMenu("定点医疗机构检测");
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);

		JMenuItem qd = new JMenuItem("目前操作员清单");
		JMenuItem jsjxx = new JMenuItem("操作员所在计算机信息");
		JMenuItem rzxx = new JMenuItem("操作员处理事务的日志信息");
		file1.add(qd);
		file1.add(jsjxx);
		file1.add(rzxx);
	
	}

}
