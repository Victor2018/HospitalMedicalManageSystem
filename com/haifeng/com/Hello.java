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

import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.haifeng.data.User;
import com.swtdesigner.SwingResourceManager;

public class Hello extends JFrame {

	private JPasswordField passwordField;
	private JTextField textField;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello dl = new Hello();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		dl.setBounds((d.width-380)/2, (d.height-280)/2, 380, 280);
		dl.setVisible(true);
		dl.setResizable(false);
		dl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Hello() {
		super();
		this.setTitle("普通用户登录");
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
					String name = textField.getText();
					String pass = new String(passwordField.getPassword());
					User user = new User();
					user.setName(name);
					user.setPass(pass);
					user.setType(1);
					try {
						Socket socket = new Socket("localhost",2013);
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						
						oos.writeObject(user);
						Object res = ois.readObject();
						if (res instanceof User) {
							JOptionPane.showMessageDialog(null, "登陆成功！");
								
							
							Success s = new Success();
							Toolkit tool = Toolkit.getDefaultToolkit();
							Dimension d = tool.getScreenSize();
							s.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
							s.setVisible(true);
							s.setResizable(false);
							Hello.this.dispose();
						} else {
							oos.close();
							ois.close();
							socket.close();
						}
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
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
		button.setIcon(SwingResourceManager.getIcon(Hello.class, "/pictures/denglu1.jpg"));
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
				
				if (textField.getText() == null || textField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(Hello.this, "用户名不能为空！");
				} else {
				String name = textField.getText();
				String pass = new String(passwordField.getPassword());
				User user = new User();
				user.setName(name);
				user.setPass(pass);
				user.setType(1);
				try {
					Socket socket = new Socket("localhost",2013);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					
					oos.writeObject(user);
					Object res = ois.readObject();
					if (res instanceof User) {
						JOptionPane.showMessageDialog(null, "登陆成功！");
						
						Success s = new Success();
						Toolkit tool = Toolkit.getDefaultToolkit();
						Dimension d = tool.getScreenSize();
						s.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
						s.setVisible(true);
						s.setResizable(false);
						Hello.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Hello.this, res);
						oos.close();
						ois.close();
						socket.close();
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
				}
			}
		});
				
		
		getContentPane().add(button);
		
		final JButton button_1 = new JButton();
		button_1.setIcon(SwingResourceManager.getIcon(Hello.class, "/pictures/zhuce1.jpg"));
		button_1.setBounds(159, 170, 75, 25);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Regist regist = new Regist();
				Toolkit tool = Toolkit.getDefaultToolkit();
				Dimension d = tool.getScreenSize();
				regist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
				regist.setVisible(true);
				regist.setResizable(false);
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
		button_2.setIcon(SwingResourceManager.getIcon(Hello.class, "/pictures/tuichu1.jpg"));
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
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("", Font.BOLD | Font.ITALIC, 15));
		label_2.setText("普通用户");
		label_2.setBounds(275, 73, 75, 15);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setIcon(SwingResourceManager.getIcon(Hello.class, "/pictures/dd.gif"));
		label_3.setBounds(0, 0, 389, 270);
		getContentPane().add(label_3);
	}
			
}

