package com.haifeng.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XiTongSheZhi extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiTongSheZhi xtsz = new XiTongSheZhi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		xtsz.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		xtsz.setVisible(true);
		xtsz.setResizable(false);
		xtsz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public XiTongSheZhi() {
		super();
		getContentPane().setLayout(null);
		
		this.setTitle("系统设置");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file1 = new JMenu("工作日志管理");
		JMenu file2 = new JMenu("系统日期");
		JMenu file3 = new JMenu("医保中心设置");
		JMenu file4 = new JMenu("系统参数设置");
		JMenu file5 = new JMenu("启动年末结转");
		JMenu file6 = new JMenu("数据移出不和备份");
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
		jmb.add(file4);
		jmb.add(file5);
		jmb.add(file6);


	}

}
