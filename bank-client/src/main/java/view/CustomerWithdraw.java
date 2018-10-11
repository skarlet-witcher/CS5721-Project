package view;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerWithdraw {

	private JFrame frmWithdrawWindow;
	private String accountNum;
	private JTextField tf_MoneyAmounts;
	private JTextField tf_accountNum;
	private JButton btn_back;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.frmWithdrawWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the application.
	 */
	public CustomerWithdraw(String accountNum) {
		this.accountNum = accountNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWithdrawWindow = new JFrame();
		frmWithdrawWindow.setTitle("Withdraw Window");
		frmWithdrawWindow.setBounds(100, 100, 505, 448);
		frmWithdrawWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWithdrawWindow.getContentPane().setLayout(null);
		
		JButton btn_withdraw = new JButton("Withdraw");
		btn_withdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_withdraw.setBounds(163, 226, 170, 57);
		frmWithdrawWindow.getContentPane().add(btn_withdraw);
		
		JLabel lblMoneyAmounts = new JLabel("Money Amounts: ");
		lblMoneyAmounts.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoneyAmounts.setBounds(42, 132, 156, 43);
		frmWithdrawWindow.getContentPane().add(lblMoneyAmounts);
		
		tf_MoneyAmounts = new JTextField();
		tf_MoneyAmounts.setBounds(208, 140, 178, 35);
		frmWithdrawWindow.getContentPane().add(tf_MoneyAmounts);
		tf_MoneyAmounts.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account number: ");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountNumber.setBounds(42, 71, 178, 43);
		frmWithdrawWindow.getContentPane().add(lblAccountNumber);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setEditable(false);
		tf_accountNum.setColumns(10);
		tf_accountNum.setBounds(208, 79, 178, 35);
		tf_accountNum.setText(accountNum);
		frmWithdrawWindow.getContentPane().add(tf_accountNum);
		
		btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWithdrawWindow.dispose();
				new CustomerWindow(accountNum).run();
			}
		});
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back.setBounds(163, 309, 170, 57);
		frmWithdrawWindow.getContentPane().add(btn_back);
	}

}
