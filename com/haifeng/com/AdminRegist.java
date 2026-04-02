package com.haifeng.com;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
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
import com.haifeng.dao.PictureBlob;
import com.haifeng.data.Doctor;
import com.haifeng.data.User;
import com.swtdesigner.SwingResourceManager;



public class AdminRegist extends JFrame {

	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_4;
	private JPasswordField passwordField_1;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminRegist aregist = new AdminRegist();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		aregist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		aregist.setVisible(true);
		aregist.setResizable(false);
		aregist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public AdminRegist() {
		super();
		this.setTitle("管理员注册");
		getContentPane().setLayout(null);
		
		final JLabel label = new JLabel();
		label.setText("用户名：");
		label.setBounds(58, 28, 60, 15);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(143, 25, 147, 21);
		getContentPane().add(textField);

		final JLabel label_1 = new JLabel();
		label_1.setText("密码：");
		label_1.setBounds(58, 63, 60, 15);
		getContentPane().add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(143, 60, 147, 21);
		getContentPane().add(passwordField);

		final JLabel label_2 = new JLabel();
		label_2.setText("性别：");
		label_2.setBounds(58, 139, 60, 15);
		getContentPane().add(label_2);
		
		final JLabel label_4 = new JLabel();
		label_4.setText("地址：");
		label_4.setBounds(58, 182, 60, 15);
		getContentPane().add(label_4);

		final JRadioButton man = new JRadioButton();
		buttonGroup.add(man);
		man.setText("男");
		man.setBounds(143, 135, 67, 23);
		man.setSelected(true);
		getContentPane().add(man);

		final JRadioButton woman = new JRadioButton();
		buttonGroup.add(woman);
		woman.setText("女");
		woman.setBounds(216, 135, 60, 23);
		getContentPane().add(woman);

		final JLabel label_3 = new JLabel();
		label_3.setText("确认密码：");
		label_3.setBounds(58, 96, 78, 15);
		getContentPane().add(label_3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(142, 93, 147, 21);
		getContentPane().add(passwordField_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 170, 250, 30);
		getContentPane().add(textField_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("年龄：");
		label_5.setBounds(58, 227, 78, 15);
		getContentPane().add(label_5);

		textField_1 = new JTextField();
		textField_1.setBounds(143, 224, 117, 21);
		getContentPane().add(textField_1);

		final JButton button = new JButton();
		button.setText("保存");
		button.setBounds(77, 379, 99, 23);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = textField.getText().trim();
				String password1 = passwordField.getText().trim();
				String password2 = passwordField_1.getText().trim();
				char sex = '女';
				if (man.isSelected()) {
					sex = '男';
				}
				
				String age =textField_1.getText().trim();
				String phone = textField_3.getText().trim();
				String mail = textField_2.getText().trim();
				String address = textField_4.getText().trim();
				
				//Pattern p = Pattern.compile("X4[0-9]{5}");//警号注册
				Pattern p1 = Pattern.compile("[a-zA-Z0-9]{1,16}@[a-z0-9]{2,10}\\.[a-z]{2,3}{1,2}"); // 邮箱校验
				Matcher m1 = p1.matcher(mail);
				boolean b1 = m1.matches();
				
				
				Pattern p2 = Pattern.compile("1[3458][0-9]{9}");
				Matcher m2 = p2.matcher(phone);
				boolean b2 = m2.matches();
				
				Pattern p3 = Pattern.compile("[1-100]");
				Matcher m3 = p3.matcher(age);
				boolean b3 = m3.matches();
				
				if (name == null || name.equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "用户名不能为空！");
				}else if (password1 == null || password1.equals("") || password2 == null || password2.equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "密码不能为空！");
				}else if (!password1.equals(password2)){
					JOptionPane.showMessageDialog(AdminRegist.this, "两次输入密码不一致！");
				}else if (address == null || address.equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "地址不能为空！");
				}else if (textField_1.getText() == null || textField_1.getText().trim().equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "年龄不能为空！");
				}else if (b3 == false){
					JOptionPane.showMessageDialog(AdminRegist.this, "年龄只能为数字！");
				}
				
				else if (mail == null || mail.equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "邮箱不能为空！");
				}else if(b1 == false){
					JOptionPane.showMessageDialog(AdminRegist.this, "邮箱输入错误！");
				}
				else if (phone == null || phone.equals("")){
					JOptionPane.showMessageDialog(AdminRegist.this, "联系方式不能为空！");
				}else if (b2 == false){
					JOptionPane.showMessageDialog(AdminRegist.this, "联系方式输入错误！");
				}
				
				
				
				else {
						Doctor d = new Doctor();
						d.setName(name);
						d.setPassword(password1);
						d.setSex(sex);
						d.setAge(age);
						d.setPhone(phone);
						d.setMail(mail);
						d.setAddress(address);
						
						DoctorDao.add(d);
						
						JOptionPane.showMessageDialog(AdminRegist.this, "注册成功！");
						AdminRegist.this.dispose();
				}
			}});
		
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.setText("取消");
		button_1.setBounds(293, 379, 99, 23);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminRegist.this.dispose();
			}});
		getContentPane().add(button_1);

		final JLabel label_6 = new JLabel();
		label_6.setText("邮箱：");
		label_6.setBounds(58, 275, 60, 15);
		getContentPane().add(label_6);

		textField_2 = new JTextField();
		textField_2.setBounds(143, 272, 177, 21);
		getContentPane().add(textField_2);

		final JLabel label_7 = new JLabel();
		label_7.setText("联系方式：");
		label_7.setBounds(58, 325, 78, 15);
		getContentPane().add(label_7);

		textField_3 = new JTextField();
		textField_3.setBounds(143, 322, 147, 21);
		getContentPane().add(textField_3);

		final JLabel label_8 = new JLabel();
		label_8.setBorder(new BevelBorder(BevelBorder.LOWERED));
		label_8.setBounds(449, 53, 99, 129);
		getContentPane().add(label_8);

		final JLabel label_9 = new JLabel();
		label_9.setText("照    片");
		label_9.setBounds(474, 28, 60, 15);
		getContentPane().add(label_9);

		final JButton button_2 = new JButton();
		button_2.setText("选择");
		button_2.setBounds(449, 202, 99, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("pictures\\");//设置选择图片的路径
				int type = jfc.showOpenDialog(AdminRegist.this);
				if (type ==0){
					System.out.println(jfc.getSelectedFile().getAbsolutePath() );
					String path = jfc.getSelectedFile().getAbsolutePath();
					label_8.setIcon(SwingResourceManager.getIcon(path));//获取选择的图片
					textField_4.setText(path);
					
					
					//PictureBlob.write(path);//保存照片到数据库
					
				}
				
			}
		});
		getContentPane().add(button_2);

		final JLabel label_10 = new JLabel();
		label_10.setIcon(SwingResourceManager.getIcon(AdminRegist.class, "/pictures/aminregist.jpg"));
		label_10.setBounds(0, 0, 600, 480);
		getContentPane().add(label_10);
	}

}
