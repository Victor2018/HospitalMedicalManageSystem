package com.haifeng.com;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import javax.swing.JFormattedTextField;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.EtchedBorder;

import com.haifeng.dao.PatientDao;
import com.haifeng.data.Patient;
import com.haifeng.jdbc.ConnectionFactory;
import com.swtdesigner.SwingResourceManager;

public class Success extends JFrame {

	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	private ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Success s = new Success();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		s.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		s.setVisible(true);
		s.setResizable(false);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Success() {
		super();
		
		getContentPane().setLayout(null);
		setSize(602, 518);
		getContentPane().setFocusTraversalPolicyProvider(true);
		this.setTitle("普通用户登录成功！");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		final JMenu file1 = new JMenu("系统管理");
		final JMenu file2 = new JMenu("注册用户");
		final JMenu file3 = new JMenu("信息查询平台");
		final JMenu file4 = new JMenu("基金征集");
		final JMenu file5 = new JMenu("费用结算");
		final JMenu file6 = new JMenu("医疗监督");
		final JMenu file7 = new JMenu("统计报表");
		final JMenu file8 = new JMenu("系统登陆");
		
		jmb.add(file1);
		jmb.add(file2);
		jmb.add(file3);
		jmb.add(file4);
		jmb.add(file5);
		jmb.add(file6);
		jmb.add(file7);
		jmb.add(file8);
		
		JMenuItem yhsz = new JMenuItem("用户设置");
		JMenuItem zccssz = new JMenuItem("政策参数设置");
		
		JMenuItem icksz = new JMenuItem("IC卡设置");
		JMenuItem sjkgl = new JMenuItem("数据库管理");
		JMenuItem xtjk = new JMenuItem("系统监控");
		JMenuItem xtsz = new JMenuItem("系统设置");
		JMenuItem xtsj = new JMenuItem("系统升级");
		JMenuItem xtgl = new JMenuItem("系统管理");
		JMenuItem bzts = new JMenuItem("帮助提示");
		
		
		file1.add(yhsz);
		file1.add(zccssz);
		file1.add(icksz);
		file1.add(sjkgl);
		file1.add(xtjk);
		file1.add(xtsz);
		file1.add(xtsj);
		file1.add(xtgl);
		file1.add(bzts);
		
		JMenuItem ptregist = new JMenuItem("普通用户注册");
		JMenuItem adminregist = new JMenuItem("管理员注册");
		
		file2.add(ptregist);
		file2.add(adminregist);
		
		JMenuItem doctor = new JMenuItem("医生信息查询（D）");
		JMenuItem patient = new JMenuItem("病人信息查询（P）");
		
		file3.add(doctor);
		file3.add(patient);
		
			doctor.addActionListener(new ActionListener(){
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DoctorMessageLook aregist = new DoctorMessageLook();
					Toolkit tool = Toolkit.getDefaultToolkit();
					Dimension d = tool.getScreenSize();
					aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
					aregist.setVisible(true);
					aregist.setResizable(false);;
				}});
		
			patient.addActionListener(new ActionListener(){
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PatientMessageLook aregist = new PatientMessageLook();
					Toolkit tool = Toolkit.getDefaultToolkit();
					Dimension d = tool.getScreenSize();
					aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
					aregist.setVisible(true);
					aregist.setResizable(false);
					
				}});
		
		ptregist.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Regist regist = new Regist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				regist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				regist.setVisible(true);
				regist.setResizable(false);
				
			}});
		
		adminregist.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminRegist aregist = new AdminRegist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				aregist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				aregist.setVisible(true);
				aregist.setResizable(false);
			}});
		
		
		JMenuItem ptyhdl = new JMenuItem("普通用户登陆（已登录）");
		ptyhdl.setEnabled(false);
		JMenuItem glydl = new JMenuItem("管理员登陆（普通用户无权限）");
		glydl.setEnabled(false);
		glydl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminHello dl = new AdminHello();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				dl.setBounds((d.width-380)/2, (d.height-280)/2, 380, 280);
				dl.setVisible(true);
				dl.setResizable(false);
			}});
		JMenuItem tcxt = new JMenuItem("退出系统");
		tcxt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int jop = JOptionPane.showConfirmDialog(Success.this, "是否确定退出系统?");
				if (jop == 0){
					System.exit(0);
					Success.this.dispose();
				}
				
			}});
		file8.add(ptyhdl);
		file8.add(glydl);
		file8.add(tcxt);

		final JLabel label = new JLabel();
		label.setText("请输入PID:");
		label.setBounds(24, 30, 82, 15);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(112, 27, 90, 21);
		getContentPane().add(textField);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pid = textField.getText().trim();
				PatientMessageLook aregist = new PatientMessageLook();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
				aregist.setVisible(true);
				aregist.setResizable(false);
				Success.this.dispose();
				
				
				
			}});
		
		button.setText("查询");
		button.setBounds(206, 26, 82, 23);
		getContentPane().add(button);

		final JLabel label_1 = new JLabel();
		label_1.setText("姓  名：");
		label_1.setBounds(46, 112, 60, 15);
		getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(112, 109, 90, 21);
		getContentPane().add(textField_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("性  别：");
		label_2.setBounds(46, 156, 60, 15);
		getContentPane().add(label_2);

		final JRadioButton man = new JRadioButton();
		buttonGroup.add(man);
		
		man.setText("男");
		man.setBounds(112, 152, 47, 23);
		getContentPane().add(man);

		final JRadioButton woman = new JRadioButton();
		buttonGroup.add(woman);
		woman.setText("女");
		woman.setBounds(155, 152, 47, 23);
		getContentPane().add(woman);

		final JLabel label_3 = new JLabel();
		label_3.setText("年  龄：");
		label_3.setBounds(46, 199, 60, 15);
		getContentPane().add(label_3);

		textField_2 = new JTextField();
		textField_2.setBounds(102, 196, 47, 21);
		getContentPane().add(textField_2);

		final JButton button_1 = new JButton();
		button_1.setText("提交");
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int res = JOptionPane.showConfirmDialog(Success.this, "是否确定提交？");
				if (res == 0){
//					Object pid = textField_7.getText();
					String name = textField_1.getText();
					char sex = '女';
					if (man.isSelected()){
						sex = '男';
					}
					Object age = textField_2.getText();
					String nation = (String) comboBox.getSelectedItem();
					String sid = textField_3.getText();
					Object wid = textField_4.getText();
					String pdate = textField_6.getText();
				
					if (name == null || name.equals("")){
						JOptionPane.showMessageDialog(Success.this, "姓名不能为空！");
					}else if (age == null || age.equals("")){
						JOptionPane.showMessageDialog(Success.this, "年龄不能为空！");
					}else if (nation == null || nation.equals("")){
						JOptionPane.showMessageDialog(Success.this, "请选择民族！");
					}else if (sid == null || sid.equals("")){
						JOptionPane.showMessageDialog(Success.this, "身份证号码不能为空！");
					}else if (wid == null || wid.equals("")){
						JOptionPane.showMessageDialog(Success.this, "医生DID不能为空！");
					}else if (pdate == null || pdate.equals("")){
						JOptionPane.showMessageDialog(Success.this, "日期不能为空！");
					}else {
						Patient p = new Patient();
						p.setName(name);
						p.setSex(sex);
						p.setAge(age);
						p.setNation(nation);
						p.setSid(sid);
						p.setWid(wid);
						p.setPdate(pdate);
						
						PatientDao.add(p);
						
					}
					JOptionPane.showMessageDialog(Success.this, textField_1.getText() + "信息已成功提交到数据库！");
				}
			}});
		button_1.setBounds(408, 348, 76, 23);
		getContentPane().add(button_1);

		final JLabel patientmessageLabel = new JLabel();
		patientmessageLabel.setText("PatientMessage");
		patientmessageLabel.setBounds(423, 62, 132, 15);
		getContentPane().add(patientmessageLabel);

		textField_5 = new JTextField();
		textField_5.setBounds(375, 83, 201, 247);
		getContentPane().add(textField_5);

		final JLabel label_10 = new JLabel();
		label_10.setText("照    片");
		label_10.setBounds(293, 62, 60, 15);
		getContentPane().add(label_10);

		final JLabel label_11 = new JLabel();
		label_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		label_11.setBounds(271, 83, 98, 113);
		getContentPane().add(label_11);

		final JButton button_2 = new JButton();
		button_2.setText("浏览");
		button_2.setBounds(285, 196, 68, 21);
		getContentPane().add(button_2);

		final JLabel label_4 = new JLabel();
		label_4.setText("民族：");
		label_4.setBounds(155, 199, 47, 15);
		getContentPane().add(label_4);

		comboBox = new JComboBox();
		comboBox.addItem("汉族");
		comboBox.addItem("土家族");
		comboBox.addItem("回族");
		comboBox.addItem("维吾尔族");
		comboBox.addItem("壮族");
		comboBox.addItem("彝族");
		comboBox.addItem("侗族");
		comboBox.addItem("苗族");
		comboBox.addItem("蒙古族");
		comboBox.addItem("满族");
		comboBox.addItem("朝鲜族");
		comboBox.addItem("赫哲族");
		comboBox.addItem("达斡尔族");
		comboBox.addItem("鄂温克族");
		comboBox.addItem("鄂伦春族");
		comboBox.addItem("东乡族");
		comboBox.addItem("土族");
		comboBox.addItem("撒拉族");
		comboBox.addItem("保安族");
		comboBox.addItem("裕固族");
		comboBox.addItem("哈萨克族");
		comboBox.addItem("柯尔克孜族");
		comboBox.addItem("锡伯族");
		comboBox.addItem("塔吉克族");
		comboBox.addItem("乌孜别克族");
		comboBox.addItem("俄罗斯族");
		comboBox.addItem("塔塔尔族");
		comboBox.addItem("藏族");
		comboBox.addItem("门巴族");
		comboBox.addItem("珞巴族");
		comboBox.addItem("羌族");
		comboBox.addItem("白族");
		comboBox.addItem("哈尼族");
		comboBox.addItem("傣族");
		comboBox.addItem("僳僳族");
		comboBox.addItem("佤族");
		comboBox.addItem("拉祜族");
		comboBox.addItem("纳西族");
		comboBox.addItem("景颇族");
		comboBox.addItem("布朗族");
		comboBox.addItem("阿昌族");
		comboBox.addItem("普米族");
		comboBox.addItem("怒族");
		comboBox.addItem("德昂族");
		comboBox.addItem("独龙族");
		comboBox.addItem("基诺族");
		comboBox.addItem("布依族");
		comboBox.addItem("水族");
		comboBox.addItem("仡佬族");
		comboBox.addItem("瑶族");
		comboBox.addItem("仫佬族");
		comboBox.addItem("毛南族");
		comboBox.addItem("京族");
		comboBox.addItem("黎族");
		comboBox.addItem("畲族");
		comboBox.addItem("高山族");
		comboBox.addItem("其他");
		comboBox.setBounds(195, 196, 76, 21);
		getContentPane().add(comboBox);

		final JLabel label_5 = new JLabel();
		label_5.setText("身份证号码：");
		label_5.setBounds(46, 242, 82, 15);
		getContentPane().add(label_5);

		textField_3 = new JTextField();
		textField_3.setBounds(123, 239, 132, 21);
		getContentPane().add(textField_3);

		final JLabel label_6 = new JLabel();
		label_6.setForeground(new Color(255, 0, 0));
		label_6.setFont(new Font("", Font.ITALIC, 11));
		label_6.setBackground(Color.RED);
		label_6.setText("* 身份证必须为18位");
		label_6.setBounds(261, 242, 112, 15);
		getContentPane().add(label_6);

		final JLabel label_7 = new JLabel();
		label_7.setText("值班人ID:");
		label_7.setBounds(46, 294, 60, 15);
		getContentPane().add(label_7);

		textField_4 = new JTextField();
		textField_4.setBounds(123, 291, 90, 21);
		getContentPane().add(textField_4);

		final JLabel label_8 = new JLabel();
		label_8.setText("日期：");
		label_8.setBounds(46, 352, 60, 15);
		getContentPane().add(label_8);

		textField_6 = new JTextField();
		textField_6.setBounds(123, 349, 112, 21);
		getContentPane().add(textField_6);

		final JLabel label_9 = new JLabel();
		label_9.setForeground(new Color(255, 0, 0));
		label_9.setFont(new Font("", Font.ITALIC, 11));
		label_9.setText("* 格式提示：20120603");
		label_9.setBounds(251, 352, 118, 15);
		getContentPane().add(label_9);

		final JLabel Label = new JLabel();
		Label.setText("  __________________________________________________________________________________");
		Label.setBounds(0, 51, 586, 15);
		getContentPane().add(Label);

		final JButton button_3 = new JButton();
		button_3.setText("修改");
		button_3.setBounds(291, 26, 82, 23);
		getContentPane().add(button_3);

		final JLabel label_12 = new JLabel();
		label_12.setIcon(SwingResourceManager.getIcon(Success.class, "/pictures/aminregist.jpg"));
		label_12.setBounds(0, 0, 600, 480);
		getContentPane().add(label_12);
	}

}
