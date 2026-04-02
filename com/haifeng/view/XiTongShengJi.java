package com.haifeng.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class XiTongShengJi extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiTongShengJi xtsj = new XiTongShengJi();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		xtsj.setBounds((d.width-800)/2, (d.height-600)/2, 800, 600);
		xtsj.setVisible(true);
		xtsj.setResizable(false);
		xtsj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public XiTongShengJi() {
		super();
		getContentPane().setLayout(null);
	}

}
