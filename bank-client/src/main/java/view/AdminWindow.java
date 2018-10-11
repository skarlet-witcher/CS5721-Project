package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminWindow {

	private JFrame frmStaffWindow;
	private JTextField tf_remove_userName;
	private JTextField tf_fristName;
	private JTextField tf_lastName;
	private JTextField tf_phoneNum;
	private JTextField tf_address;
	private JTextField tf_email;
	private JTextField tf_pwd;
	private JTextField tf_confirmPwd;
	private JTextField tf_userName;

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}
	
	public void run() {
		try {
			this.frmStaffWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffWindow = new JFrame();
		frmStaffWindow.setTitle("Admin Window");
		frmStaffWindow.setBounds(100, 100, 1194, 794);
		frmStaffWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcomeToStaff = new JLabel("Welcome to Admin Window");
		lblWelcomeToStaff.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		tf_fristName = new JTextField();
		tf_fristName.setColumns(10);
		tf_fristName.setBounds(137, 87, 150, 20);
		panel_3.add(tf_fristName);
		
		JLabel lblFirstName = new JLabel("First name: \r\n");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(10, 88, 96, 14);
		panel_3.add(lblFirstName);
		
		JButton btn_addAccount = new JButton("Add an account");
		btn_addAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_addAccount.setBounds(99, 339, 160, 38);
		panel_3.add(btn_addAccount);
		
		tf_lastName = new JTextField();
		tf_lastName.setColumns(10);
		tf_lastName.setBounds(137, 125, 150, 20);
		panel_3.add(tf_lastName);
		
		JLabel lblLastName = new JLabel("Last name: \r\n");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(10, 123, 96, 20);
		panel_3.add(lblLastName);
		
		JLabel lblContactNumber = new JLabel("Phone Number:\r\n");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContactNumber.setBounds(10, 227, 127, 20);
		panel_3.add(lblContactNumber);
		
		tf_phoneNum = new JTextField();
		tf_phoneNum.setColumns(10);
		tf_phoneNum.setBounds(137, 229, 150, 20);
		panel_3.add(tf_phoneNum);
		
		JButton btnNewButton_2 = new JButton("Sign out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffWindow.dispose();
				new MainMenu().run();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frmStaffWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addGap(202)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(421, Short.MAX_VALUE)
					.addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addGap(414))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(469)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		
		JButton btn_add_reset = new JButton("Reset\r\n\r\n");
		btn_add_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_add_reset.setBounds(99, 388, 160, 38);
		panel_3.add(btn_add_reset);
		
		JLabel lblHomeAddress = new JLabel("Address:");
		lblHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHomeAddress.setBounds(10, 259, 104, 38);
		panel_3.add(lblHomeAddress);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(137, 270, 150, 20);
		panel_3.add(tf_address);
		
		JLabel lblAddAnAccount = new JLabel("Add an account");
		lblAddAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddAnAccount.setBounds(76, 11, 145, 36);
		panel_3.add(lblAddAnAccount);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 290, 104, 38);
		panel_3.add(lblEmail);
		
		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(137, 301, 150, 20);
		panel_3.add(tf_email);
		
		JLabel lblPassword = new JLabel("Password:\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 156, 127, 20);
		panel_3.add(lblPassword);
		
		tf_pwd = new JTextField();
		tf_pwd.setColumns(10);
		tf_pwd.setBounds(137, 156, 150, 20);
		panel_3.add(tf_pwd);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:\r\n");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(10, 187, 127, 20);
		panel_3.add(lblConfirmPassword);
		
		tf_confirmPwd = new JTextField();
		tf_confirmPwd.setColumns(10);
		tf_confirmPwd.setBounds(137, 189, 150, 20);
		panel_3.add(tf_confirmPwd);
		
		JLabel lblUserName = new JLabel("User name: \r\n");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserName.setBounds(10, 59, 96, 14);
		panel_3.add(lblUserName);
		
		tf_userName = new JTextField();
		tf_userName.setColumns(10);
		tf_userName.setBounds(137, 58, 150, 20);
		panel_3.add(tf_userName);
		panel.setLayout(null);
		
		tf_remove_userName = new JTextField();
		tf_remove_userName.setBounds(141, 87, 122, 20);
		panel.add(tf_remove_userName);
		tf_remove_userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User name: \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 86, 123, 19);
		panel.add(lblNewLabel);
		
		JButton btn_removeAccount = new JButton("Remove an account");
		btn_removeAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_removeAccount.setBounds(73, 200, 192, 38);
		panel.add(btn_removeAccount);
		
		JLabel lblRemoveAnAccount = new JLabel("Remove an account");
		lblRemoveAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRemoveAnAccount.setBounds(73, 24, 192, 38);
		panel.add(lblRemoveAnAccount);
		
		JButton btn_remove_reset = new JButton("Reset");
		btn_remove_reset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_remove_reset.setBounds(73, 255, 192, 38);
		panel.add(btn_remove_reset);
		frmStaffWindow.getContentPane().setLayout(groupLayout);
	}
}
