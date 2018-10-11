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
		
		JLabel lblWelcomeFirstname = new JLabel("Welcome");
		lblWelcomeFirstname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcomeFirstname.setBounds(222, 42, 111, 105);
		frmCustomerWindow.getContentPane().add(lblWelcomeFirstname);
		
		JLabel lblYourCardNumber = new JLabel("Your card number is: ");
		lblYourCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourCardNumber.setBounds(36, 159, 146, 29);
		frmCustomerWindow.getContentPane().add(lblYourCardNumber);
		
		JButton btn_viewBalance = new JButton("View Balance");
		btn_viewBalance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_viewBalance.setBounds(66, 344, 213, 63);
		frmCustomerWindow.getContentPane().add(btn_viewBalance);
		
		JLabel lbl_cardNum = new JLabel("**********");
		lbl_cardNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_cardNum.setBounds(192, 164, 124, 19);
		lbl_cardNum.setText(accountNum);
		frmCustomerWindow.getContentPane().add(lbl_cardNum);
		
		JButton btn_withdraw = new JButton("Withdraw");
		btn_withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerWithdraw(accountNum).run();
			}
		});
		btn_withdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_withdraw.setBounds(443, 252, 213, 63);
		frmCustomerWindow.getContentPane().add(btn_withdraw);
		
		JButton btn_signout = new JButton("Sign out");
		btn_signout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new MainMenu().run();
			}
		});
		btn_signout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_signout.setBounds(252, 498, 213, 63);
		frmCustomerWindow.getContentPane().add(btn_signout);
		
		JButton btn_modifyAccount = new JButton("Modify Account\r\n");
		btn_modifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerModifyAccount(accountNum).run();
			}
		});
		btn_modifyAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_modifyAccount.setBounds(66, 252, 213, 63);
		frmCustomerWindow.getContentPane().add(btn_modifyAccount);
		
		JButton btn_deposit = new JButton("Make a deposit");
		btn_deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerDeposit(accountNum).run();
			}
		});
		btn_deposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_deposit.setBounds(443, 344, 213, 63);
		frmCustomerWindow.getContentPane().add(btn_deposit);
		
		JLabel lblYourUserId = new JLabel("Your User ID is: ");
		lblYourUserId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourUserId.setBounds(36, 199, 146, 29);
		frmCustomerWindow.getContentPane().add(lblYourUserId);
		
		JLabel lbl_userId = new JLabel("<dynamic>");
		lbl_userId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_userId.setBounds(192, 208, 124, 19);
		frmCustomerWindow.getContentPane().add(lbl_userId);
		
		JLabel lbl_firstName = new JLabel("Customer");
		lbl_firstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_firstName.setBounds(343, 42, 111, 105);
		frmCustomerWindow.getContentPane().add(lbl_firstName);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCustomerWindow.dispose();
				new CustomerTransfer(accountNum).run();
			}
		});
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTransfer.setBounds(443, 164, 213, 63);
		frmCustomerWindow.getContentPane().add(btnTransfer);
		
		
	}
}
