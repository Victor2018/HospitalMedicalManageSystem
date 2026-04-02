package com.haifeng.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;

public class ICKaiSheZhi extends JFrame {

	private JTable table;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICKaiSheZhi icksz = new ICKaiSheZhi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		icksz.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		icksz.setVisible(true);
		icksz.setResizable(false);
		icksz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public ICKaiSheZhi() {
		super();
		getContentPane().setLayout(null);

		

		this.setTitle("IC卡设置");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file1 = new JMenu("IC卡厂商选定");
		JMenu file2 = new JMenu("IC卡密码设置");
		JMenu file3 = new JMenu("IC卡端口设置");
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
	}

	
}
