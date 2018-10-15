/*
 * Created by JFormDesigner on Mon Oct 15 22:02:45 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class StaffMainView extends JFrame {
    public StaffMainView() {
        initComponents();
    }

    private void btn_signoutActionPerformed(ActionEvent e) {
        this.dispose();
        new StaffLoginView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tab_staffTab = new JTabbedPane();
        requestPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table_requestTable = new JTable();
        btn_accept = new JButton();
        btn_decline = new JButton();
        removePanel = new JPanel();
        lbl_accountNum = new JLabel();
        tf_accountNum = new JTextField();
        btn_remove = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Staff Main View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== tab_staffTab ========
        {
            tab_staffTab.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //======== requestPanel ========
            {
                requestPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane1 ========
                {

                    //---- table_requestTable ----
                    table_requestTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "First Name", "Last Name", "Gender", "Identity Type", "Identity Number", "Account Type", "Card Type", "Graduate Date", "Date of Birth", "Address", "Email", "Contact Number"
                        }
                    ));
                    table_requestTable.setMinimumSize(new Dimension(500, 48));
                    table_requestTable.setPreferredSize(new Dimension(1000, 48));
                    scrollPane1.setViewportView(table_requestTable);
                }
                requestPanel.add(scrollPane1, "cell 0 0,wmin 800");

                //---- btn_accept ----
                btn_accept.setText("Accept");
                btn_accept.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                requestPanel.add(btn_accept, "cell 0 1");

                //---- btn_decline ----
                btn_decline.setText("Decline");
                btn_decline.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                requestPanel.add(btn_decline, "cell 0 2");
            }
            tab_staffTab.addTab("New Customer Request", requestPanel);

            //======== removePanel ========
            {
                removePanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[300:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[150:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[100:n]"));

                //---- lbl_accountNum ----
                lbl_accountNum.setText("Account Number");
                lbl_accountNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                removePanel.add(lbl_accountNum, "cell 1 1");

                //---- tf_accountNum ----
                tf_accountNum.setMinimumSize(new Dimension(100, 30));
                removePanel.add(tf_accountNum, "cell 2 1");

                //---- btn_remove ----
                btn_remove.setText("Remove");
                btn_remove.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                removePanel.add(btn_remove, "cell 1 3 2 1");
            }
            tab_staffTab.addTab("Remove a customer account", removePanel);
        }
        contentPane.add(tab_staffTab, "cell 0 0,wmin 800");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_signoutActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 0 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tab_staffTab;
    private JPanel requestPanel;
    private JScrollPane scrollPane1;
    private JTable table_requestTable;
    private JButton btn_accept;
    private JButton btn_decline;
    private JPanel removePanel;
    private JLabel lbl_accountNum;
    private JTextField tf_accountNum;
    private JButton btn_remove;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
