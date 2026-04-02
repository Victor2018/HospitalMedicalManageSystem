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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.haifeng.dao.PageModel;
import com.haifeng.dao.PatientDao;
import com.haifeng.data.MyTableModel;
import com.haifeng.data.Patient;
import com.swtdesigner.SwingResourceManager;

public class PatientMessage extends JFrame {

	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private PageModel pm = new PageModel();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatientMessage hay = new PatientMessage(null);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		hay.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		hay.setVisible(true);
		hay.setResizable(false);
		hay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public PatientMessage(Patient p) {
		super();
		final JButton button_4 = new JButton();
		final JButton button_5 = new JButton();
		getContentPane().setLayout(null);
		setSize(602, 518);
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
		
		
		JMenuItem ptyhdl = new JMenuItem("普通用户登陆（已登陆）");
		ptyhdl.setEnabled(false);
		ptyhdl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Hello dl = new Hello();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				dl.setBounds((d.width-380)/2, (d.height-280)/2, 380, 280);
				dl.setVisible(true);
				dl.setResizable(false);
				
			}});
		JMenuItem glydl = new JMenuItem("管理员登陆（普通用户无权限）");
		glydl.setEnabled(false);
		JMenuItem tcxt = new JMenuItem("退出系统");
		tcxt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int jop = JOptionPane.showConfirmDialog(PatientMessage.this, "是否确定退出系统?");
				if (jop == 0){
					System.exit(0);
					PatientMessage.this.dispose();
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

		final JLabel label_2 = new JLabel();
		label_2.setText("性  别：");
		label_2.setBounds(46, 156, 60, 15);
		getContentPane().add(label_2);
		
		final JRadioButton man = new JRadioButton();
		String sex1 = (p.getSex() + "").trim();
		if (sex1.equals("男")){
			man.setSelected(true);
		}
		buttonGroup.add(man);
		man.setText("男");
		man.setBounds(112, 152, 47, 23);
		getContentPane().add(man);
		
		final JRadioButton woman = new JRadioButton();
		String sex2 = (p.getSex() + "").trim();
		if (sex2.equals("女")){
			woman.setSelected(true);
		}
		buttonGroup.add(woman);
		woman.setText("女");
		woman.setBounds(155, 152, 47, 23);
		getContentPane().add(woman);
		
		final JButton button = new JButton();
		
		button.setText("修改");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(PatientMessage.this, "是否确定提交？");
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
						JOptionPane.showMessageDialog(PatientMessage.this, "姓名不能为空！");
					}else if (age == null || age.equals("")){
						JOptionPane.showMessageDialog(PatientMessage.this, "年龄不能为空！");
					}else if (nation == null || nation.equals("")){
						JOptionPane.showMessageDialog(PatientMessage.this, "请选择民族！");
					}else if (sid == null || sid.equals("")){
						JOptionPane.showMessageDialog(PatientMessage.this, "身份证号码不能为空！");
					}else if (wid == null || wid.equals("")){
						JOptionPane.showMessageDialog(PatientMessage.this, "医生DID不能为空！");
					}else if (pdate == null || pdate.equals("")){
						JOptionPane.showMessageDialog(PatientMessage.this, "日期不能为空！");
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
						
					}
					JOptionPane.showMessageDialog(PatientMessage.this, textField_1.getText() + "信息已成功提交到数据库！");
					textField_7.setText("");
					textField_1.setText("");
					
				    textField_2.setText("");
					comboBox.getSelectedItem();
					textField_3.setText("");
					textField_4.setText("");
					textField_6.setText("");
				}
				
				
			}});
		button.setBounds(208, 26, 82, 23);
		getContentPane().add(button);

		final JLabel label_1 = new JLabel();
		label_1.setText("姓  名：");
		label_1.setBounds(46, 112, 60, 15);
		getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setText(p.getName());
		textField_1.setBounds(112, 109, 68, 21);
		getContentPane().add(textField_1);

		

		final JLabel label_3 = new JLabel();
		label_3.setText("年  龄：");
		label_3.setBounds(46, 199, 60, 15);
		getContentPane().add(label_3);

		textField_2 = new JTextField();
		textField_2.setText(p.getAge() + "");
		textField_2.setBounds(102, 196, 47, 21);
		getContentPane().add(textField_2);

		final JButton button_1 = new JButton();
		button_1.setText("返回");
		button_1.setBounds(293, 26, 76, 23);
		getContentPane().add(button_1);

		final JLabel patientmessageLabel = new JLabel();
		patientmessageLabel.setText("PatientMessage");
		patientmessageLabel.setBounds(423, 62, 132, 15);
		getContentPane().add(patientmessageLabel);

		table = new JTable();
		table.setSelectionBackground(Color.blue);
		pm.setTableName("patient");
		if (pm.getTableRow() == 0){
			JOptionPane.showMessageDialog(PatientMessage.this, "该表没数据");
			return ;
		}
		pm.setCurrentPage(1);
		init();
		
		if (pm.isNext()) {
			button_5.setEnabled(true);
		}
		if (pm.isPrev()) {
			button_4.setEnabled(true);
		}
		table.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
					//table.setSelectionBackground(Color.blue);
					int row = table.getSelectedRow();
					MyTableModel atm = (MyTableModel) table.getModel();
					Object[] datas = atm.getRow(row);
					Patient p = new Patient();
					p.setPid(Integer.parseInt(datas[1] + ""));
					p.setName(datas[2] + "");
					p.setSex((datas[3] + "").charAt(0));
					p.setAge(Integer.parseInt(datas[4] + ""));
					p.setNation(datas[5] + "");
					p.setSid(datas[6] + "");
					p.setWid(datas[7] + "");
					p.setPdate(datas[8] + "");
					
					PatientMessageOp pmo = new PatientMessageOp(p,PatientMessage.this);
					Toolkit tool = Toolkit.getDefaultToolkit();
					Dimension d = tool.getScreenSize();
					pmo.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
					pmo.setVisible(true);
				}
				
				
			}});
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(375, 83, 201, 187);
		getContentPane().add(jsp); //设置滚动条

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
		comboBox.addItem(p.getNation());
		comboBox.setBounds(195, 196, 76, 21);
		getContentPane().add(comboBox);

		final JLabel label_5 = new JLabel();
		label_5.setText("身份证号码：");
		label_5.setBounds(46, 242, 82, 15);
		getContentPane().add(label_5);

		textField_3 = new JTextField();
		textField_3.setText(p.getSid());
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
		textField_4.setText(p.getWid() + "");
		textField_4.setBounds(123, 291, 90, 21);
		getContentPane().add(textField_4);

		final JLabel label_8 = new JLabel();
		label_8.setText("日期：");
		label_8.setBounds(46, 352, 60, 15);
		getContentPane().add(label_8);

		textField_6 = new JTextField();
		textField_6.setText(p.getPdate());
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
		Label.setBounds(0, 41, 586, 15);
		getContentPane().add(Label);

		final JLabel pidLabel = new JLabel();
		pidLabel.setText("P I D:");
		pidLabel.setBounds(46, 76, 60, 15);
		getContentPane().add(pidLabel);

		textField_7 = new JTextField();
		textField_7.setText(p.getPid() + "");
		textField_7.setBounds(112, 70, 90, 21);
		getContentPane().add(textField_7);

		final JButton button_3 = new JButton();
		button_3.setText("首页");
		button_3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pm.setCurrentPage(1);
				table.setModel(new MyTableModel(pm.getDatas()));
				button_4.setEnabled(false);
				if (pm.isNext()) {
					button_5.setEnabled(true);
				} else {
					button_5.setEnabled(false);
				}
				
			}});
		button_3.setBounds(375, 276, 76, 23);
		getContentPane().add(button_3);

		//final JButton button_4 = new JButton();
		button_4.setText("上一页");
		button_4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pm.setCurrentPage(pm.getCurrentPage() - 1);
				table.setModel(new MyTableModel(pm.getDatas()));
				if (pm.isNext()) {
					button_5.setEnabled(true);
				} else {
					button_5.setEnabled(false);
				}
				if (pm.isPrev()) {
					button_4.setEnabled(true);
				} else {
					button_4.setEnabled(false);
				}
				
				
			}});
		button_4.setBounds(375, 305, 83, 23);
		getContentPane().add(button_4);

		//final JButton button_5 = new JButton();
		button_5.setText("下一页");
		button_5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pm.setCurrentPage(pm.getCurrentPage() + 1);
				table.setModel(new MyTableModel(pm.getDatas()));
				if (pm.isNext()) {
					button_5.setEnabled(true);
				} else {
					button_5.setEnabled(false);
				}
				if (pm.isPrev()) {
					button_4.setEnabled(true);
				} else {
					button_4.setEnabled(false);
				}
			}});
		button_5.setBounds(495, 305, 81, 23);
		getContentPane().add(button_5);

		final JButton button_6 = new JButton();
		button_6.setText("尾页");
		button_6.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pm.setCurrentPage(pm.getTotalPage());
				table.setModel(new MyTableModel(pm.getDatas()));
			
				button_5.setEnabled(false);
				
				if (pm.isPrev()) {
					button_4.setEnabled(true);
				} else {
					button_4.setEnabled(false);
				}
				
			}});
		button_6.setBounds(500, 276, 76, 23);
		getContentPane().add(button_6);
		
		final JLabel bj = new JLabel();
		bj.setIcon(SwingResourceManager.getIcon(AdminRegist.class, "/pictures/hnybj.jpg"));
		bj.setBounds(0, 0, 600, 480);
		getContentPane().add(bj);
	}

	public void init(){
		pm.setCurrentPage(pm.getCurrentPage());
		table.setModel(new MyTableModel(pm.getDatas()));
	}
	
	
	
}
