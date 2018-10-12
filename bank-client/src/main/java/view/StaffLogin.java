package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffLogin {

	private JFrame frmStaffLogin;
	private JTextField tf_admin_username;
	private JTextField tf_admin_pwd;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.frmStaffLogin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public StaffLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffLogin = new JFrame();
		frmStaffLogin.setTitle("Staff Login");
		frmStaffLogin.setBounds(100, 100, 565, 582);
		frmStaffLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStaffLogin.getContentPane().setLayout(null);
		
		JLabel lblStaffId = new JLabel("Admin Name:");
		lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffId.setBounds(81, 99, 163, 32);
		frmStaffLogin.getContentPane().add(lblStaffId);
		
		tf_admin_username = new JTextField();
		tf_admin_username.setColumns(10);
		tf_admin_username.setBounds(254, 108, 192, 22);
		frmStaffLogin.getContentPane().add(tf_admin_username);
		
		JLabel label_1 = new JLabel("Password:\r\n");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(81, 183, 163, 32);
		frmStaffLogin.getContentPane().add(label_1);
		
		tf_admin_pwd = new JTextField();
		tf_admin_pwd.setColumns(10);
		tf_admin_pwd.setBounds(254, 193, 192, 22);
		frmStaffLogin.getContentPane().add(tf_admin_pwd);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffLogin.dispose();
				new StaffWindow().run();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(199, 288, 225, 57);
		frmStaffLogin.getContentPane().add(button);
		
		JButton button_1 = new JButton("Back to Main menu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffLogin.dispose();
				new MainMenu().run();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(199, 383, 225, 57);
		frmStaffLogin.getContentPane().add(button_1);
	}

}
