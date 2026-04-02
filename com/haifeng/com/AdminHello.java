package com.haifeng.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.haifeng.data.User;
import com.haifeng.jdbc.ConnectionFactory;
import com.swtdesigner.SwingResourceManager;

public class AdminHello extends JFrame {

	private JPasswordField passwordField;
	private JTextField textField;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminHello dl = new AdminHello();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		dl.setBounds((d.width-380)/2, (d.height-280)/2, 380, 280);
		dl.setVisible(true);
		dl.setResizable(false);
		dl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public AdminHello() {
		super();
		this.setTitle("管理员登录");
		getContentPane().setLayout(null);
		setJMenuBar(null);

		final JLabel label = new JLabel();
		label.setText("用户名:");
		label.setBounds(65, 75, 60, 15);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("密    码:");
		label_1.setBounds(65, 115, 60, 15);
		getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(139, 70, 129, 21);
		getContentPane().add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(139, 110, 129, 21);
		passwordField.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			if (e.getKeyCode()==10){
				String name1 = textField.getText().trim();
				String password1 = new String(passwordField.getPassword()).trim();
				
					Connection conn = null; // 声明数据连接对象
					Statement st = null; // 声明Statement对象
					ResultSet rs = null; // 声明结果集对象
					conn = ConnectionFactory.getConnection(); // 建立数据连接
					try {
						st = conn.createStatement();
						rs = st.executeQuery("select * from doctor where name ='" + name1+ "'");
						if (rs.next() && rs.getString("name") != null){
							String name2 = rs.getString(2);
							String password2 = rs.getString(3);
							if(name2.equals(name1) && password2.equals(password1)){
								JOptionPane.showMessageDialog(AdminHello.this, "登陆成功！");
								AdminHello.this.dispose();
								AdminSuccess as = new AdminSuccess();
								Toolkit tool = Toolkit.getDefaultToolkit();
								Dimension d = tool.getScreenSize();
								as.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
								as.setVisible(true);
								as.setResizable(false);
							}else if(!password1.equals(password2)){
								JOptionPane.showMessageDialog(null, "密码错误！");
							}
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(AdminHello.this, e1.getMessage(), "数据库异常！", JOptionPane.INFORMATION_MESSAGE);//显示消息框
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
//				System.out.println(e.getKeyCode());//打印键盘的编码值
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		getContentPane().add(passwordField);

		final JButton button = new JButton();
		button.setIcon(SwingResourceManager.getIcon(AdminHello.class, "/pictures/denglu1.jpg"));
		button.setBounds(55, 170, 75, 25);
		button.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon( new ImageIcon("pictures\\denglu2.jpg"));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon( new ImageIcon("pictures\\denglu1.jpg"));
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon( new ImageIcon("pictures\\denglu1.jpg"));
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setIcon( new ImageIcon("pictures\\denglu2.jpg"));
			}});
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name1 = textField.getText().trim();
				String password1 = new String(passwordField.getPassword()).trim();
				if (name1 == null || name1.equals("")) {
					JOptionPane.showMessageDialog(AdminHello.this, "请输入用户名！");
				}else if (password1 == null || password1.equals("")){
					JOptionPane.showMessageDialog(AdminHello.this, "请输入密码！");
				}else {
					Connection conn = null; // 声明数据连接对象
					Statement st = null; // 声明Statement对象
					ResultSet rs = null; // 声明结果集对象
					conn = ConnectionFactory.getConnection(); // 建立数据连接
					try {
						st = conn.createStatement();
						rs = st.executeQuery("select * from doctor where name ='" + name1+ "'");
						if (rs.next() && rs.getString("name") != null){
							String name2 = rs.getString(2);
							String password2 = rs.getString(3);
							if(name2.equals(name1) && password2.equals(password1)){
								JOptionPane.showMessageDialog(AdminHello.this, "登陆成功！");
								AdminHello.this.dispose();
								AdminSuccess as = new AdminSuccess();
								Toolkit tool = Toolkit.getDefaultToolkit();
								Dimension d = tool.getScreenSize();
								as.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
								as.setVisible(true);
								as.setResizable(false);
							}else if (name2.equals(name1) && !password2.equals(password1)){
								JOptionPane.showMessageDialog(AdminHello.this, "密码错误！请重新输入密码");
								passwordField.setText("");
							}else if (!name2.equals(name1) && password2.equals(password1)){
								JOptionPane.showMessageDialog(AdminHello.this, "用户名错误！请核对用户名！");
								passwordField.setText("");
							}
							else {
								JOptionPane.showMessageDialog(AdminHello.this, "用户或密码错误！");
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(AdminHello.this, e1.getMessage(), "数据库异常！", JOptionPane.INFORMATION_MESSAGE);//显示消息框
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
		
		final JButton button_1 = new JButton();
		button_1.setIcon(SwingResourceManager.getIcon(AdminHello.class, "/pictures/zhuce1.jpg"));
		button_1.setBounds(159, 170, 75, 25);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminRegist aregist = new AdminRegist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				aregist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				aregist.setVisible(true);
				aregist.setResizable(false);
			}});
		button_1.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button_1.setIcon( new ImageIcon("pictures\\zhuce2.jpg"));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button_1.setIcon( new ImageIcon("pictures\\zhuce1.jpg"));
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				button_1.setIcon( new ImageIcon("pictures\\zhuce1.jpg"));
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				button_1.setIcon( new ImageIcon("pictures\\zhuce2.jpg"));
			}});
		getContentPane().add(button_1);

		final JButton button_2 = new JButton();
		button_2.setIcon(SwingResourceManager.getIcon(AdminHello.class, "/pictures/tuichu1.jpg"));
		button_2.setBounds(260, 170, 75, 25);
		button_2.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button_2.setIcon( new ImageIcon("pictures\\tuichu2.jpg"));
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button_2.setIcon( new ImageIcon("pictures\\tuichu1.jpg"));
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				button_2.setIcon( new ImageIcon("pictures\\tuichu1.jpg"));
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				button_2.setIcon( new ImageIcon("pictures\\tuichu2.jpg"));
			}});
		button_2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(null, "是否确定退出系统?");
				if (res == 0){
					System.exit(0);
				}
				
			}});
		getContentPane().add(button_2);

		final JLabel label_2 = new JLabel();
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setFont(new Font("", Font.BOLD | Font.ITALIC, 15));
		label_2.setText("管理员");
		label_2.setBounds(275, 73, 85, 15);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setIcon(SwingResourceManager.getIcon(AdminHello.class, "/pictures/dd.gif"));
		label_3.setBounds(0, 0, 390, 262);
		getContentPane().add(label_3);
	}
			
}

