package com.haifeng.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ZhengCeCanShuSheZhi extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZhengCeCanShuSheZhi zccssz = new ZhengCeCanShuSheZhi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		zccssz.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		zccssz.setVisible(true);
		zccssz.setResizable(false);
		zccssz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public ZhengCeCanShuSheZhi() {
		super();
		getContentPane().setLayout(null);
		this.setTitle("政策参数设置");
		
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		
		JMenu file1 = new JMenu("基金征集比例设置");
		file1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ZhengCeCanShuSheZhi zccssz = new ZhengCeCanShuSheZhi();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				zccssz.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
				zccssz.setVisible(true);
				zccssz.setResizable(false);
			}});
		JMenu file2 = new JMenu("个人账户划拨比例");
		JMenu file3 = new JMenu("政策参数设置");
		JMenu file4 = new JMenu("基金类别参数");
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
		jmb.add(file4);
		
		JMenuItem zzjjzjbl = new JMenuItem("在职基金征集比例");
		JMenuItem txjjzjbl = new JMenuItem("退休基金征集比例");
		JMenuItem lxjjzjbl = new JMenuItem("离休基金征集比例");
		JMenuItem scjjzjbl = new JMenuItem("伤残基金征集比例");
		JMenuItem tzryjjzjbl = new JMenuItem("退职人员基金征集比例");
		file1.add(zzjjzjbl);
		file1.add(txjjzjbl);
		file1.add(lxjjzjbl);
		file1.add(scjjzjbl);
		file1.add(tzryjjzjbl);
		
		JMenuItem qfdcssz = new JMenuItem("起付段参数设置");
		JMenuItem tcfdcssz = new JMenuItem("统筹分段参数设置");
		JMenuItem qtcssz = new JMenuItem("其他参数设置");
		file3.add(qfdcssz);
		file3.add(tcfdcssz);
		file3.add(qtcssz);
		
		JMenuItem jjlb = new JMenuItem("基金类别");
		JMenuItem sfqz = new JMenuItem("是否起征");
		JMenuItem qzny = new JMenuItem("起征年月");
		file4.add(jjlb);
		file4.add(sfqz);
		file4.add(qzny);
		
		
	}

}
