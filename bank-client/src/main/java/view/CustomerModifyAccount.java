package view;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerModifyAccount {

	private JFrame frmModifyAnAccount;
	private String accountNum;
	private JTextField tf_accountNum;
	private JTextField tf_firstName;
	private JTextField tf_lastName;
	private JTextField tf_phoneNum;
	private JTextField tf_address;
	private JButton btnBack;
	private JLabel lblEmail;
	private JTextField tf_email;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.frmModifyAnAccount.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public CustomerModifyAccount(String accountNum) {
		this.accountNum = accountNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifyAnAccount = new JFrame();
		frmModifyAnAccount.setTitle("Modify an account\r\n");
		frmModifyAnAccount.setBounds(0, -14, 508, 641);
		frmModifyAnAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModifyAnAccount.getContentPane().setLayout(null);
		
		JButton btn_modify = new JButton("Modify");
		btn_modify.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_modify.setBounds(151, 422, 170, 48);
		frmModifyAnAccount.getContentPane().add(btn_modify);
		
		JLabel lblAccountNumber = new JLabel("Account number: \r\n");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccountNumber.setBounds(34, 50, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblAccountNumber);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setEditable(false);
		tf_accountNum.setColumns(10);
		tf_accountNum.setBounds(207, 59, 193, 26);
		tf_accountNum.setText(accountNum);
		frmModifyAnAccount.getContentPane().add(tf_accountNum);
		
		JLabel lblFirstName = new JLabel("First Name: \r\n");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(34, 99, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: \r\n");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(34, 153, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblLastName);
		
		JLabel lblContactNumber = new JLabel("Phone number: \r\n");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber.setBounds(34, 216, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblContactNumber);
		
		JLabel lblhomeAddressLine = new JLabel("Address:");
		lblhomeAddressLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblhomeAddressLine.setBounds(34, 275, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblhomeAddressLine);
		
		tf_firstName = new JTextField();
		tf_firstName.setEditable(false);
		tf_firstName.setColumns(10);
		tf_firstName.setBounds(207, 111, 193, 26);
		frmModifyAnAccount.getContentPane().add(tf_firstName);
		
		tf_lastName = new JTextField();
		tf_lastName.setEditable(false);
		tf_lastName.setColumns(10);
		tf_lastName.setBounds(207, 165, 193, 26);
		frmModifyAnAccount.getContentPane().add(tf_lastName);
		
		tf_phoneNum = new JTextField();
		tf_phoneNum.setColumns(10);
		tf_phoneNum.setBounds(207, 228, 193, 26);
		frmModifyAnAccount.getContentPane().add(tf_phoneNum);
		
		tf_address = new JTextField();
		tf_address.setColumns(10);
		tf_address.setBounds(207, 276, 193, 26);
		frmModifyAnAccount.getContentPane().add(tf_address);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModifyAnAccount.dispose();
				new CustomerWindow(accountNum).run();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(151, 519, 170, 48);
		frmModifyAnAccount.getContentPane().add(btnBack);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(34, 324, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblEmail);
		
		tf_email = new JTextField();
		tf_email.setColumns(10);
		tf_email.setBounds(207, 325, 193, 26);
		frmModifyAnAccount.getContentPane().add(tf_email);
	}
}
