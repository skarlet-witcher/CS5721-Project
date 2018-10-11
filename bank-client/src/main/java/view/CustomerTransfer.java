package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerTransfer {

	private JFrame frame;
	private JTextField tf_accountNum;
	private JTextField tf_moneyAmounts;
	private JTextField tf_toAccountNum;
	private String accountNum;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the application.
	 */
	public CustomerTransfer(String accountNum) {
		this.accountNum = accountNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Account number: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(70, 78, 178, 43);
		frame.getContentPane().add(label);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setText("<dynamic>");
		tf_accountNum.setEditable(false);
		tf_accountNum.setColumns(10);
		tf_accountNum.setBounds(236, 86, 178, 35);
		frame.getContentPane().add(tf_accountNum);
		
		JLabel label_1 = new JLabel("Money Amounts: ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(70, 188, 156, 43);
		frame.getContentPane().add(label_1);
		
		tf_moneyAmounts = new JTextField();
		tf_moneyAmounts.setColumns(10);
		tf_moneyAmounts.setBounds(236, 196, 178, 35);
		frame.getContentPane().add(tf_moneyAmounts);
		
		JButton btn_transfer = new JButton("Transfer");
		btn_transfer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_transfer.setBounds(180, 312, 170, 57);
		frame.getContentPane().add(btn_transfer);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CustomerWindow(accountNum).run();
			}
		});
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_back.setBounds(180, 380, 170, 57);
		frame.getContentPane().add(btn_back);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTo.setBounds(70, 134, 156, 43);
		frame.getContentPane().add(lblTo);
		
		tf_toAccountNum = new JTextField();
		tf_toAccountNum.setColumns(10);
		tf_toAccountNum.setBounds(236, 142, 178, 35);
		frame.getContentPane().add(tf_toAccountNum);
	}

}
