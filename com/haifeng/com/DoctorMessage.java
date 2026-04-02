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



public class DoctorMessage extends JFrame {

	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField_1;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorMessage aregist = new DoctorMessage(null);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		aregist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		aregist.setVisible(true);
		aregist.setResizable(false);
		aregist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public DoctorMessage(Doctor d) {
		super();
		this.setTitle("管理员注册");
		getContentPane().setLayout(null);
		
		final JLabel label = new JLabel();
		label.setText("用户名：");
		label.setBounds(58, 28, 60, 15);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setText(d.getName());
		textField.setBounds(143, 25, 147, 21);
		getContentPane().add(textField);

		final JLabel label_1 = new JLabel();
		label_1.setText("DID：");
		label_1.setBounds(58, 63, 60, 15);
		getContentPane().add(label_1);

	    textField_5 = new JTextField();
	    textField_5.setText(d.getDid() + "");
	    textField_5.setBounds(143, 60, 147, 21);
		getContentPane().add(textField_5);

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
		String s = (d.getSex() + "").trim();
		if (s.equals("男")){
			man.setSelected(true);
		}
		getContentPane().add(man);

		final JRadioButton woman = new JRadioButton();
		buttonGroup.add(woman);
		woman.setText("女");
		woman.setBounds(216, 135, 60, 23);
		String s1 = (d.getSex() + "").trim();
		if (s1.equals("女")){
			woman.setSelected(true);
		}
		getContentPane().add(woman);

		final JLabel label_3 = new JLabel();
		label_3.setText("密码：");
		label_3.setBounds(58, 96, 78, 15);
		getContentPane().add(label_3);

		textField_6 = new JTextField();
		textField_6.setText(d.getPassword());
		textField_6.setBounds(142, 93, 147, 21);
		getContentPane().add(textField_6);
		
		textField_4 = new JTextField();
		textField_4.setText(d.getAddress());
		textField_4.setBounds(138, 170, 250, 30);
		getContentPane().add(textField_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("年龄：");
		label_5.setBounds(58, 227, 78, 15);
		getContentPane().add(label_5);

		textField_1 = new JTextField();
		textField_1.setText(d.getAge() + "");
		textField_1.setBounds(143, 224, 117, 21);
		getContentPane().add(textField_1);

		final JButton button = new JButton();
		button.setText("修改");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(DoctorMessage.this, "是否确定提交？");
				if (res == 0){
					
					String name = textField.getText().trim();
					Object did = textField_5.getText().trim();
					String password = textField_6.getText().trim();
					char sex = '女';
					if (man.isSelected()){
						sex = '男';
					}
					String address = textField_4.getText().trim();
					Object age = textField_1.getText().trim();
					String mail = textField_2.getText().trim();
					String phone = textField_3.getText().trim();
					
				
					if (name == null || name.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "姓名不能为空！");
					}else if (age == null || age.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "年龄不能为空！");
					}else if (password == null || did.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "请输入密码！");
					}else if (address == null || address.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "地址不能为空！");
					}else if (age == null || age.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "年龄不能为空！");
					}else if (mail == null || mail.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "邮箱不能为空！");
					}else if (phone == null || phone.equals("")){
						JOptionPane.showMessageDialog(DoctorMessage.this, "联系方式不能为空！");
					}else {
						
							Doctor d = new Doctor();
							d.setName(name);
							d.setDid(did);
							d.setPassword(password);
							d.setSex(sex);
							d.setAddress(address);
							d.setAge(age);
							d.setMail(mail);
							d.setPhone(phone);
							
							
							DoctorDao.update(d);
						
					}
					JOptionPane.showMessageDialog(DoctorMessage.this, textField.getText() + "信息已成功提交到数据库！");
					textField.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_4.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				}
				
				
				
			}});
		button.setBounds(77, 379, 99, 23);
		
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.setText("取消");
		button_1.setBounds(293, 379, 99, 23);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DoctorMessage.this.dispose();
			}});
		getContentPane().add(button_1);

		final JLabel label_6 = new JLabel();
		label_6.setText("邮箱：");
		label_6.setBounds(58, 275, 60, 15);
		getContentPane().add(label_6);

		textField_2 = new JTextField();
		textField_2.setText(d.getMail());
		textField_2.setBounds(143, 272, 177, 21);
		getContentPane().add(textField_2);

		final JLabel label_7 = new JLabel();
		label_7.setText("联系方式：");
		label_7.setBounds(58, 325, 78, 15);
		getContentPane().add(label_7);

		textField_3 = new JTextField();
		textField_3.setText(d.getPhone());
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

		final JLabel label_10 = new JLabel();
		label_10.setIcon(SwingResourceManager.getIcon(DoctorMessage.class, "/pictures/doctormessage.jpg"));
		label_10.setBounds(0, 0, 600, 480);
		getContentPane().add(label_10);
	}

}
