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
import com.haifeng.dao.PictureBlob;
import com.haifeng.data.Doctor;
import com.haifeng.data.User;
import com.haifeng.jdbc.ConnectionFactory;
import com.swtdesigner.SwingResourceManager;



public class DoctorMessageLook extends JFrame {
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorMessageLook aregist = new DoctorMessageLook();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		aregist.setBounds((d.width-400)/2, (d.height-300)/2, 400, 300);
		aregist.setVisible(true);
		aregist.setResizable(false);
		aregist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public DoctorMessageLook() {
		super();
		this.setTitle("医生信息查询");
		getContentPane().setLayout(null);
		
		final JLabel label = new JLabel();
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("", Font.BOLD, 14));
		label.setBackground(getBackground());
		label.setText("请输入你要查询的DID编号：");
		label.setBounds(10, 39, 200, 50);
		getContentPane().add(label);


		textField = new JTextField();
		textField.setBounds(71, 92, 163, 30);
		textField.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==10){
					String t = textField.getText().trim();
					
					Connection conn = null; // 声明数据连接对象
					Statement st = null; // 声明Statement对象
					ResultSet rs = null; // 声明结果集对象
					conn = ConnectionFactory.getConnection(); // 建立数据连接
					try {
						st = conn.createStatement();
						String id = textField.getText().trim();
						rs = st.executeQuery("select * from doctor where did ='" + id+ "'");
						if (rs.next() && rs.getString("did") != null){
							Doctor d = new Doctor();
							d.setDid(rs.getInt(1));
							d.setName(rs.getString(2));
							d.setPassword(rs.getString(3));
							d.setSex(rs.getString(4).charAt(0));
							d.setAge(rs.getInt(5));
							d.setPhone(rs.getString(6));
							d.setMail(rs.getString(7));
							d.setAddress(rs.getString(8));
							
							DoctorMessage am = new DoctorMessage(d);
							Toolkit tool = Toolkit.getDefaultToolkit();
							Dimension dd = tool.getScreenSize();
							am.setBounds((dd.width-600)/2, (dd.height-480)/2, 600, 480);
							am.setVisible(true);
							am.setResizable(false);
							textField.setText("");
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								"数据库异常", JOptionPane.INFORMATION_MESSAGE); // 显示消息框
						try {
							conn.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		getContentPane().add(textField);
	
		final JButton button = new JButton();
		button.setText("查询");
		button.setBounds(71, 177, 60, 30);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t = textField.getText().trim();
				if (t == null || t.equals("")){
					JOptionPane.showMessageDialog(DoctorMessageLook.this, "请输入你要查询的DID!");
				}else{
				Connection conn = null; // 声明数据连接对象
				Statement st = null; // 声明Statement对象
				ResultSet rs = null; // 声明结果集对象
				conn = ConnectionFactory.getConnection(); // 建立数据连接
				try {
					st = conn.createStatement();
					String id = textField.getText().trim();
					rs = st.executeQuery("select * from doctor where did ='" + id+ "'");
					if (rs.next() && rs.getString("did") != null){
						Doctor d = new Doctor();
						d.setDid(rs.getInt(1));
						d.setName(rs.getString(2));
						d.setPassword(rs.getString(3));
						d.setSex(rs.getString(4).charAt(0));
						d.setAge(rs.getInt(5));
						d.setPhone(rs.getString(6));
						d.setMail(rs.getString(7));
						d.setAddress(rs.getString(8));
						
						DoctorMessage am = new DoctorMessage(d);
						Toolkit tool = Toolkit.getDefaultToolkit();
						Dimension dd = tool.getScreenSize();
						am.setBounds((dd.width-600)/2, (dd.height-480)/2, 600, 480);
						am.setVisible(true);
						am.setResizable(false);
						textField.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "对不起" + textField.getText().trim() + "信息不存在");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"数据库异常", JOptionPane.INFORMATION_MESSAGE); // 显示消息框
					try {
						conn.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				} 
			}});
		
		getContentPane().add(button);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t = textField.getText().trim();
				if (t == null || t.equals("")){
					JOptionPane.showMessageDialog(null, "请输入你要删除的DID!");
					
				}else {
				Doctor d = new Doctor();
				int res = JOptionPane.showConfirmDialog(DoctorMessageLook.this, "确定要删除" +textField.getText() + "相关信息吗？");
				if (res == 0){
					Connection conn = null; // 声明数据连接对象
					Statement st = null; // 声明Statement对象
					ResultSet rs = null; // 声明结果集对象
					conn = ConnectionFactory.getConnection(); // 建立数据连接
					try {
						st = conn.createStatement();
						String id = textField.getText().trim();
						rs = st.executeQuery("select * from doctor where did ='" + id+ "'");
						if (rs.next() && rs.getString("did") != null){
							d.setDid(rs.getInt(1));
							DoctorDao.delete(d);
							textField.setText("");
						}
						
						else {
							JOptionPane.showMessageDialog(null, "对不起" + textField.getText() + "信息不存在");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								"数据库异常", JOptionPane.INFORMATION_MESSAGE); // 显示消息框
						try {
							conn.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} 
					
					
					JOptionPane.showMessageDialog(DoctorMessageLook.this, d.getDid() + "信息删除成功！");
				}
				
				}
			}});
		button_2.setText("删除");
		button_2.setBounds(174, 177, 60, 30);

		getContentPane().add(button_2);
		
		final JButton button_1 = new JButton();
		button_1.setText("取消");
		button_1.setBounds(268, 177, 60, 30);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DoctorMessageLook.this.dispose();
			}});
		getContentPane().add(button_1);

		final JLabel label_1 = new JLabel();
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("", Font.BOLD, 18));
		label_1.setText("医    生    信    息    查    询");
		label_1.setBounds(88, 10, 223, 23);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.BOLD | Font.ITALIC, 12));
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setText("* 格式：101");
		label_2.setBounds(240, 99, 88, 15);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setIcon(SwingResourceManager.getIcon(DoctorMessageLook.class, "/pictures/aminregist.jpg"));
		label_3.setBounds(0, 0, 410, 288);
		getContentPane().add(label_3);
	}

}
