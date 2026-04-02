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

import com.haifeng.data.User;
import com.swtdesigner.SwingResourceManager;



public class Regist extends JFrame {

	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JPasswordField passwordField_1;
	private ButtonGroup buttonGroup_1 = new ButtonGroup();
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regist regist = new Regist();
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		regist.setBounds((d.width-600)/2, (d.height-480)/2, 600, 480);
		regist.setVisible(true);
		regist.setResizable(false);
		regist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Regist() {
		super();
		this.setTitle("普通用户注册");
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

		final JLabel label_4 = new JLabel();
		label_4.setText("头像：");
		label_4.setBounds(58, 182, 60, 15);
		getContentPane().add(label_4);

		
		DefaultComboBoxModel comModel = new DefaultComboBoxModel();
		File file = new File("images");
		String[] names = file.list();
		for (String name : names) {
			comModel.addElement("images\\" + name);
		}
		comboBox = new JComboBox(comModel);
		
		ListCellRenderer arenderer = new ListCellRenderer(){

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				// TODO Auto-generated method stub
				JLabel icon = new JLabel();
				ImageIcon ic = new ImageIcon(value + "");
				icon.setIcon(ic);
				return icon;
			}
			
		};
		comboBox.setRenderer(arenderer);
		comboBox.setBounds(138, 159, 122, 53);
		
		getContentPane().add(comboBox);

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
				String pass1 = passwordField.getText().trim();
				String pass2 = passwordField_1.getText().trim();
				String sex = "女";
				if (man.isSelected()) {
					sex = "男";
				}
				String icon = comboBox.getSelectedItem() + "";
				int age = Integer.parseInt(textField_1.getText());
				
				String email = textField_2.getText();
				String phone = textField_3.getText();
				
				User user = new User();
				user.setAge(age);
				user.setEmail(email);
				user.setIcon(icon);
				user.setName(name);
				user.setPass(pass1);
				user.setPhone(phone);
				user.setSex(sex.charAt(0));
					
				
				/*String s1 = textField_2.getText();
				Pattern p1 = Pattern.compile("[a-zA-Z0-9]{1,16}@[A-Z0-9]{2,10}(\\.[a-z]{2,3}){1,2}");
				Matcher m1 = p1.matcher(s1);
				boolean b1 = m1.matches();
			
				String s2 = textField_2.getText();
				Pattern p2 = Pattern.compile("1[3458][0-9]{9}");
				Matcher m2 = p2.matcher(s2);
				boolean b2 = m2.matches();*/
				
				
				
				if(name == null ||name.equals("")){
						JOptionPane.showMessageDialog(Regist.this, "用户名不为空！");
					}else if(pass1 == null||pass2 == null ||pass1.equals("")||pass2.equals("")){
						JOptionPane.showMessageDialog(Regist.this, "密码不为空！");
					}else if(pass1.equals(pass2)!=true){
						JOptionPane.showMessageDialog(Regist.this, "两次输入密码不一样！");
						passwordField.setText("");
						passwordField_1.setText("");
					}else if(textField_1.getText() == null){
						JOptionPane.showMessageDialog(Regist.this , "年龄不能为空");
						
					}
					/*else if (b2 == false){
						JOptionPane.showMessageDialog(Regist.this, "电话号码输入不正确！");
					}*/

					else{ 
						try {
					Socket socket = new Socket("localhost",2013);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					oos.writeObject(user);
					oos.flush();
					Object res = ois.readObject();
					if (res.equals("success")) {
						JOptionPane.showMessageDialog(Regist.this, "注册成功");
						Regist.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Regist.this, "用户名已被注册！");
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
		button_1.setText("取消");
		button_1.setBounds(293, 379, 99, 23);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Regist.this.dispose();
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
				int type = jfc.showOpenDialog(Regist.this);
				if (type ==0){
					System.out.println(jfc.getSelectedFile().getAbsolutePath() );
					String picture = jfc.getSelectedFile().getAbsolutePath();
					label_8.setIcon(SwingResourceManager.getIcon(picture));//获取选择的图片
					
				}
				
			}
		});
		getContentPane().add(button_2);

		final JLabel label_10 = new JLabel();
		label_10.setIcon(SwingResourceManager.getIcon(Regist.class, "/pictures/hnybj.jpg"));
		label_10.setBounds(0, 0, 600, 480);
		getContentPane().add(label_10);
	}

}
