package view;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class ModifyAccountWindow {

	private JFrame frmModifyAnAccount;
	private String accountNum;
	private JTextField tf_accountNum;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
	public ModifyAccountWindow(String accountNum) {
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
		
		JButton btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnModify.setBounds(166, 478, 135, 38);
		frmModifyAnAccount.getContentPane().add(btnModify);
		
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
		
		JLabel lblContactNumber = new JLabel("Contact number: \r\n");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber.setBounds(34, 216, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblContactNumber);
		
		JLabel lblhomeAddressLine = new JLabel("<html>Home address <br/> Line 1: </html>");
		lblhomeAddressLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblhomeAddressLine.setBounds(34, 275, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblhomeAddressLine);
		
		JLabel lblLine = new JLabel("Line 2: \r\n");
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLine.setBounds(34, 324, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblLine);
		
		JLabel lblLine_1 = new JLabel("Line 3: \r\n");
		lblLine_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLine_1.setBounds(34, 373, 163, 38);
		frmModifyAnAccount.getContentPane().add(lblLine_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(207, 111, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(207, 165, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(207, 228, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(207, 276, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(207, 336, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(207, 385, 193, 26);
		frmModifyAnAccount.getContentPane().add(textField_5);
	}
}
