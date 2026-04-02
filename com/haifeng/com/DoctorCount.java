package com.haifeng.com;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

import com.haifeng.dao.DoctorDao;
import com.haifeng.dao.DoctorPageModel;
import com.haifeng.dao.PictureBlob;
import com.haifeng.data.Doctor;
import com.haifeng.data.User;
import com.haifeng.jdbc.ConnectionFactory;
import com.swtdesigner.SwingResourceManager;



public class DoctorCount extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private DoctorPageModel dpm = new DoctorPageModel();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorCount dc = new DoctorCount(null);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		dc.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
		dc.setVisible(true);
		dc.setResizable(false);
		dc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public DoctorCount(Doctor d) {
		super();
		this.setTitle("总计信息查询");
		getContentPane().setLayout(null);
		
		final JLabel label = new JLabel();
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("", Font.BOLD, 14));
		label.setBackground(getBackground());
		label.setText("当前医生和病人总数如下：");
		label.setBounds(10, 39, 200, 50);
		getContentPane().add(label);


		textField = new JTextField();
		textField.setBounds(71, 92, 163, 30);
		textField.setText(dpm.getTableRow()+ "");
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 135, 163, 30);
		getContentPane().add(textField_1);
	
		
		final JButton button_1 = new JButton();
		button_1.setText("确定");
		button_1.setBounds(268, 177, 60, 30);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DoctorCount.this.dispose();
			}});
		getContentPane().add(button_1);

		final JLabel label_1 = new JLabel();
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("", Font.BOLD, 18));
		label_1.setText("总    计    信    息    查    询");
		label_1.setBounds(88, 10, 223, 23);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setText("医生总数");
		label_2.setBounds(240, 99, 88, 15);
		getContentPane().add(label_2);
		
		final JLabel label_4 = new JLabel();
		label_4.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		label_4.setForeground(new Color(255, 0, 0));
		label_4.setText("病人总数");
		label_4.setBounds(240, 140, 88, 15);
		getContentPane().add(label_4);
		

		final JLabel label_3 = new JLabel();
		label_3.setIcon(SwingResourceManager.getIcon(DoctorCount.class, "/pictures/aminregist.jpg"));
		label_3.setBounds(0, 0, 410, 288);
		getContentPane().add(label_3);
	}

}
