package com.haifeng.view;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javax.swing.JFrame;


public class ShuJuKuGuanLi extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuJuKuGuanLi sjkgl = new ShuJuKuGuanLi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		sjkgl.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
		sjkgl.setVisible(true);
		sjkgl.setResizable(false);
		sjkgl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public ShuJuKuGuanLi() {
		super();
		getContentPane().setLayout(null);

		this.setTitle("数据库管理");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file1 = new JMenu("备份数据库");
		JMenu file2 = new JMenu("恢复数据库");
		jmb.add(file1);
		jmb.add(file2);
	}

}
