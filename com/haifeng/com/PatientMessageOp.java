package com.haifeng.com;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.haifeng.dao.PageModel;
import com.haifeng.dao.PatientDao;
import com.haifeng.data.MyTableModel;
import com.haifeng.data.Patient;
import com.swtdesigner.SwingResourceManager;

public class PatientMessageOp extends JFrame {

	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JTextField textField_1;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private PageModel pm = new PageModel();
	/**
	 * @param message 
	 * @param p 
	 * @param args
	 */
	public PatientMessageOp(final Patient p, final PatientMessage pm) {
		super();
		final JButton button_4 = new JButton();
		final JButton button_5 = new JButton();
		getContentPane().setLayout(null);
		setSize(602, 486);
		getContentPane().setFocusTraversalPolicyProvider(true);
		this.setTitle("普通用户登录成功！");
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		final JMenu file1 = new JMenu("系统管理");
		final JMenu file2 = new JMenu("基础数据");
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
		
		file1.setEnabled(false);
		file2.setEnabled(false);
		file3.setEnabled(false);
		file4.setEnabled(false);
		file5.setEnabled(false);
		file6.setEnabled(false);
		file7.setEnabled(false);
		file8.setEnabled(false);
		
		JMenuItem ptyhdl = new JMenuItem("普通用户登陆（已登录）");
		ptyhdl.setEnabled(false);
		JMenuItem glydl = new JMenuItem("管理员登陆（普通用户无权限）");
		glydl.setEnabled(false);
		
		JMenuItem tcxt = new JMenuItem("退出系统");
		tcxt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int jop = JOptionPane.showConfirmDialog(PatientMessageOp.this, "是否确定退出系统?");
				if (jop == 0){
					System.exit(0);
					PatientMessageOp.this.dispose();
				}
				
			}});
		file8.add(ptyhdl);
		file8.add(glydl);
		file8.add(tcxt);

		final JLabel label_2 = new JLabel();
		label_2.setText("性  别：");
		label_2.setBounds(46, 127, 60, 15);
		getContentPane().add(label_2);
		
		final JRadioButton man = new JRadioButton();
		buttonGroup.add(man);
		String sex1 = (p.getSex() + "").trim();
		if (sex1.equals("男")){
			man.setSelected(true);
		}
		man.setText("男");
		man.setBounds(114, 123, 47, 23);
		getContentPane().add(man);
		
		final JRadioButton woman = new JRadioButton();
		buttonGroup.add(woman);
		String sex2 = (p.getSex() + "").trim();
		if (sex2.equals("女")){
			woman.setSelected(true);
		}
		woman.setText("女");
		woman.setBounds(167, 123, 47, 23);
		getContentPane().add(woman);
		
		final JButton button = new JButton();
		
		button.setText("提交");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(PatientMessageOp.this, "是否确定提交？");
				if (res == 0){
					Object pid = textField_7.getText();
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
						JOptionPane.showMessageDialog(PatientMessageOp.this, "姓名不能为空！");
					}else if (age == null || age.equals("")){
						JOptionPane.showMessageDialog(PatientMessageOp.this, "年龄不能为空！");
					}else if (nation == null || nation.equals("")){
						JOptionPane.showMessageDialog(PatientMessageOp.this, "请选择民族！");
					}else if (sid == null || sid.equals("")){
						JOptionPane.showMessageDialog(PatientMessageOp.this, "身份证号码不能为空！");
					}else if (wid == null || wid.equals("")){
						JOptionPane.showMessageDialog(PatientMessageOp.this, "医生DID不能为空！");
					}else if (pdate == null || pdate.equals("")){
						JOptionPane.showMessageDialog(PatientMessageOp.this, "日期不能为空！");
					}else {
						
							Patient p = new Patient();
							p.setPid(pid);
							p.setName(name);
							p.setSex(sex);
							p.setAge(age);
							p.setNation(nation);
							p.setSid(sid);
							p.setWid(wid);
							p.setPdate(pdate);
							
							PatientDao.update(p);
							JOptionPane.showMessageDialog(PatientMessageOp.this, "更新成功！");
							PatientMessageOp.this.dispose();
							pm.init();
						
					}
					JOptionPane.showMessageDialog(PatientMessageOp.this, textField_1.getText() + "信息已成功提交到数据库！");
					textField_7.setText("");
					textField_1.setText("");
					
				    textField_2.setText("");
					comboBox.getSelectedItem();
					textField_3.setText("");
					textField_4.setText("");
					textField_6.setText("");
				}
				
				
			}});
		button.setBounds(164, 376, 82, 23);
		getContentPane().add(button);

		final JLabel label_1 = new JLabel();
		label_1.setText("姓  名：");
		label_1.setBounds(46, 76, 60, 15);
		getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setText(p.getName());
		textField_1.setBounds(112, 73, 68, 21);
		getContentPane().add(textField_1);

		

		final JLabel label_3 = new JLabel();
		label_3.setText("年  龄：");
		label_3.setBounds(46, 171, 60, 15);
		getContentPane().add(label_3);

		textField_2 = new JTextField();
		textField_2.setText(p.getAge() + "");
		textField_2.setBounds(114, 168, 66, 21);
		getContentPane().add(textField_2);

		final JButton button_1 = new JButton();
		button_1.setText("返回");
		button_1.setBounds(331, 376, 76, 23);
		getContentPane().add(button_1);


		

		final JLabel label_10 = new JLabel();
		label_10.setText("照    片");
		label_10.setBounds(465, 52, 60, 15);
		getContentPane().add(label_10);

		final JLabel label_11 = new JLabel();
		label_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		label_11.setBounds(442, 73, 98, 113);
		getContentPane().add(label_11);

		final JButton button_2 = new JButton();
		button_2.setText("浏览");
		button_2.setBounds(457, 192, 68, 21);
		getContentPane().add(button_2);

		final JLabel label_4 = new JLabel();
		label_4.setText("民族：");
		label_4.setBounds(220, 127, 47, 15);
		getContentPane().add(label_4);

		comboBox = new JComboBox();
		comboBox.addItem(p.getNation());
		comboBox.setBounds(273, 124, 76, 21);
		getContentPane().add(comboBox);

		final JLabel label_5 = new JLabel();
		label_5.setText("身份证号码：");
		label_5.setBounds(46, 228, 82, 15);
		getContentPane().add(label_5);

		textField_3 = new JTextField();
		textField_3.setText(p.getSid());
		textField_3.setBounds(114, 225, 132, 21);
		getContentPane().add(textField_3);

		final JLabel label_6 = new JLabel();
		label_6.setForeground(new Color(255, 0, 0));
		label_6.setFont(new Font("", Font.ITALIC, 11));
		label_6.setBackground(Color.RED);
		label_6.setText("* 身份证必须为18位");
		label_6.setBounds(257, 229, 112, 15);
		getContentPane().add(label_6);

		final JLabel label_7 = new JLabel();
		label_7.setText("值班人ID:");
		label_7.setBounds(46, 294, 60, 15);
		getContentPane().add(label_7);

		textField_4 = new JTextField();
		textField_4.setText(p.getWid() + "");
		textField_4.setBounds(114, 291, 90, 21);
		getContentPane().add(textField_4);

		final JLabel label_8 = new JLabel();
		label_8.setText("日期：");
		label_8.setBounds(46, 337, 60, 15);
		getContentPane().add(label_8);

		textField_6 = new JTextField();
		textField_6.setText(p.getPdate());
		textField_6.setBounds(114, 334, 112, 21);
		getContentPane().add(textField_6);

		final JLabel label_9 = new JLabel();
		label_9.setForeground(new Color(255, 0, 0));
		label_9.setFont(new Font("", Font.ITALIC, 11));
		label_9.setText("* 格式提示：20120603");
		label_9.setBounds(232, 338, 118, 15);
		getContentPane().add(label_9);

		final JLabel pidLabel = new JLabel();
		pidLabel.setText("P I D:");
		pidLabel.setBounds(211, 76, 60, 15);
		getContentPane().add(pidLabel);

		textField_7 = new JTextField();
		textField_7.setText(p.getPid() + "");
		textField_7.setEditable(false);
		textField_7.setBounds(293, 73, 90, 21);
		getContentPane().add(textField_7);
		
		final JLabel bj = new JLabel();
		bj.setIcon(SwingResourceManager.getIcon(AdminRegist.class, "/pictures/hnybj.jpg"));
		bj.setBounds(0, 0, 600, 480);
		getContentPane().add(bj);


	}
	
}
