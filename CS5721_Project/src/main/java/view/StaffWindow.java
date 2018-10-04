package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffWindow {

	private JFrame frmStaffWindow;
	private JTextField tf_modify_accountNum;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.frmStaffWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public StaffWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffWindow = new JFrame();
		frmStaffWindow.setTitle("Staff Window");
		frmStaffWindow.setBounds(100, 100, 1376, 686);
		frmStaffWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcomeToStaff = new JLabel("Welcome to Staff Window");
		lblWelcomeToStaff.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 22, 96, 20);
		panel_1.add(textField_1);
		
		JLabel label = new JLabel("Account Number: \r\n");
		label.setBounds(12, 25, 104, 14);
		panel_1.add(label);
		
		JButton button = new JButton("Reset\r\n");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(229, 21, 64, 23);
		panel_1.add(button);
		
		JButton btnMakeADeposit = new JButton("Make a deposit");
		btnMakeADeposit.setBounds(67, 114, 156, 38);
		panel_1.add(btnMakeADeposit);
		
		JButton btnWithdrawMoney = new JButton("Withdraw money\r\n");
		btnWithdrawMoney.setBounds(67, 189, 156, 38);
		panel_1.add(btnWithdrawMoney);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 22, 96, 20);
		panel_2.add(textField_3);
		
		JLabel lblFrom = new JLabel("From: \r\n");
		lblFrom.setBounds(12, 25, 96, 14);
		panel_2.add(lblFrom);
		
		JButton button_1 = new JButton("Reset\r\n");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(221, 21, 64, 23);
		panel_2.add(button_1);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(76, 164, 135, 38);
		panel_2.add(btnTransfer);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(115, 57, 96, 20);
		panel_2.add(textField_4);
		
		JButton button_5 = new JButton("Reset\r\n");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_5.setBounds(221, 56, 64, 23);
		panel_2.add(button_5);
		
		JLabel lblTo = new JLabel("To: \r\n");
		lblTo.setBounds(12, 60, 96, 20);
		panel_2.add(lblTo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(115, 22, 150, 20);
		panel_3.add(textField_6);
		
		JLabel lblFirstName = new JLabel("First name: \r\n");
		lblFirstName.setBounds(12, 25, 96, 14);
		panel_3.add(lblFirstName);
		
		JButton btnAddAnAccount = new JButton("Add an account");
		btnAddAnAccount.setBounds(76, 230, 135, 38);
		panel_3.add(btnAddAnAccount);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(115, 53, 150, 20);
		panel_3.add(textField_7);
		
		JLabel lblLastName = new JLabel("Last name: \r\n");
		lblLastName.setBounds(12, 60, 96, 20);
		panel_3.add(lblLastName);
		
		JLabel lblContactNumber = new JLabel("Contact number:");
		lblContactNumber.setBounds(12, 91, 104, 20);
		panel_3.add(lblContactNumber);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(115, 91, 150, 20);
		panel_3.add(textField_8);
		
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(503, Short.MAX_VALUE)
					.addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addGap(496))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(550, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(535))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		
		JButton btnReset = new JButton("Reset\r\n\r\n");
		btnReset.setBounds(76, 279, 135, 38);
		panel_3.add(btnReset);
		
		JLabel lblHomeAddress = new JLabel("<html>Home address <br/> Line 1: </html>");
		lblHomeAddress.setBounds(12, 123, 96, 28);
		panel_3.add(lblHomeAddress);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(115, 120, 150, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(115, 154, 150, 20);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(115, 188, 150, 20);
		panel_3.add(textField_11);
		
		JLabel lblLine = new JLabel("Line 2:");
		lblLine.setBounds(12, 157, 96, 20);
		panel_3.add(lblLine);
		
		JLabel lblLine_1 = new JLabel("Line 3:");
		lblLine_1.setBounds(12, 188, 96, 20);
		panel_3.add(lblLine_1);
		
		JLabel label_3 = new JLabel("Money Amounts: \r\n");
		label_3.setBounds(12, 93, 104, 20);
		panel_2.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(115, 93, 96, 20);
		panel_2.add(textField_5);
		
		JButton button_3 = new JButton("Reset\r\n");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_3.setBounds(221, 92, 64, 23);
		panel_2.add(button_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 59, 96, 20);
		panel_1.add(textField_2);
		
		JButton button_4 = new JButton("Reset\r\n");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_4.setBounds(229, 56, 64, 23);
		panel_1.add(button_4);
		
		JLabel lblNewLabel_1 = new JLabel("Money Amounts: \r\n");
		lblNewLabel_1.setBounds(12, 60, 104, 20);
		panel_1.add(lblNewLabel_1);
		panel.setLayout(null);
		
		tf_modify_accountNum = new JTextField();
		tf_modify_accountNum.setBounds(116, 22, 96, 20);
		panel.add(tf_modify_accountNum);
		tf_modify_accountNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Account Number: \r\n");
		lblNewLabel.setBounds(10, 25, 104, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reset\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(222, 21, 64, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify an account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyAccountWindow(tf_modify_accountNum.getText().trim()).run();
			}
		});
		btnNewButton_1.setBounds(66, 76, 160, 38);
		panel.add(btnNewButton_1);
		
		JButton btnRemoveAnAccount = new JButton("Remove an account");
		btnRemoveAnAccount.setBounds(66, 138, 160, 38);
		panel.add(btnRemoveAnAccount);
		
		JButton btnViewTheBalance = new JButton("View the balance of an account\r\n");
		btnViewTheBalance.setBounds(39, 197, 216, 38);
		panel.add(btnViewTheBalance);
		frmStaffWindow.getContentPane().setLayout(groupLayout);
	}
}
