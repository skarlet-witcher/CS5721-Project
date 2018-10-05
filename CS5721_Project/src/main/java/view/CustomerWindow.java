package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerWindow {

	private JFrame frmCustomerWindow;
	private String accountNum;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			frmCustomerWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public CustomerWindow(String accountNum) {
		this.accountNum = accountNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerWindow = new JFrame();
		frmCustomerWindow.setTitle("Customer Window");
		frmCustomerWindow.setBounds(100, 100, 751, 636);
		frmCustomerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerWindow.getContentPane().setLayout(null);
		
		JLabel lblWelcomeFirstname = new JLabel("Welcome (FirstName) !");
		lblWelcomeFirstname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcomeFirstname.setBounds(222, 42, 349, 105);
		frmCustomerWindow.getContentPane().add(lblWelcomeFirstname);
		
		JLabel lblYourCardNumber = new JLabel("Your card number is: ");
		lblYourCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourCardNumber.setBounds(36, 159, 146, 29);
		frmCustomerWindow.getContentPane().add(lblYourCardNumber);
		
		JButton btnNewButton = new JButton("View Balance");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(256, 269, 213, 63);
		frmCustomerWindow.getContentPane().add(btnNewButton);
		
		JLabel lbl_accountNum = new JLabel("**********");
		lbl_accountNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_accountNum.setBounds(192, 164, 124, 19);
		lbl_accountNum.setText(accountNum);
		frmCustomerWindow.getContentPane().add(lbl_accountNum);
		
		JButton btnMakeADeposit = new JButton("Withdraw");
		btnMakeADeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerWithdrawWindow(accountNum).run();
			}
		});
		btnMakeADeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMakeADeposit.setBounds(490, 269, 213, 63);
		frmCustomerWindow.getContentPane().add(btnMakeADeposit);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new MainMenu().run();
			}
		});
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignOut.setBounds(244, 446, 213, 63);
		frmCustomerWindow.getContentPane().add(btnSignOut);
		
		JButton btnModifyAccount = new JButton("Modify Account\r\n");
		btnModifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerModifyAccountWindow(accountNum).run();
			}
		});
		btnModifyAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModifyAccount.setBounds(10, 269, 213, 63);
		frmCustomerWindow.getContentPane().add(btnModifyAccount);
		
		
	}
}
