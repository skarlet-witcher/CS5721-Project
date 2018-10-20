/*
 * Created by JFormDesigner on Mon Oct 15 22:30:55 BST 2018
 */

package view;

import javax.swing.table.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai22
 */
public class AdminMainView extends JFrame {
    public AdminMainView() {
        initComponents();
    }

    private void btn_signoutActionPerformed(ActionEvent e) {
        this.dispose();
        new AdminLoginView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void tf_searchFocusGained(FocusEvent e) {
        tf_search.selectAll();
    }

    private void tf_searchFocusLost(FocusEvent e) {

    }

    private void btn_addStaffActionPerformed(ActionEvent e) {
        this.dispose();
        new AdminAddStaffView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        addStaffPanel = new JPanel();
        tf_search = new JTextField();
        btn_search = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btn_addStaff = new JButton();
        btn_removeStaff = new JButton();
        modifyEmailPanel = new JPanel();
        lbl_emailHost = new JLabel();
        tf_emailHost = new JTextField();
        lbl_emailPort = new JLabel();
        tf_emailPort = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_emailPwd = new JLabel();
        pf_emailPwd = new JPasswordField();
        lbl_emailConfirmPwd = new JLabel();
        pf_emailConfirmPwd = new JPasswordField();
        btn_checkAvailability = new JButton();
        btn_modify = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Admin Main View");
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
            "[]" +
            "[]"));

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            tabbedPane1.setMinimumSize(new Dimension(500, 411));

            //======== addStaffPanel ========
            {
                addStaffPanel.setMinimumSize(new Dimension(1005, 230));
                addStaffPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[50:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[50:n]"));

                //---- tf_search ----
                tf_search.setText("filtered by id, first name, last name");
                tf_search.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        tf_searchFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        tf_searchFocusLost(e);
                    }
                });
                addStaffPanel.add(tf_search, "cell 0 1");

                //---- btn_search ----
                btn_search.setText("Search");
                btn_search.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(btn_search, "cell 0 1");

                //======== scrollPane1 ========
                {
                    scrollPane1.setMinimumSize(new Dimension(500, 21));

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                        },
                        new String[] {
                            "Staff Id", "First name", "Last name", "Password", "Email", "Status"
                        }
                    ));
                    table1.setMinimumSize(new Dimension(500, 32));
                    scrollPane1.setViewportView(table1);
                }
                addStaffPanel.add(scrollPane1, "cell 0 2");

                //---- btn_addStaff ----
                btn_addStaff.setText("Add a staff");
                btn_addStaff.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                btn_addStaff.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_addStaffActionPerformed(e);
                    }
                });
                addStaffPanel.add(btn_addStaff, "cell 0 4");

                //---- btn_removeStaff ----
                btn_removeStaff.setText("Remove a staff");
                btn_removeStaff.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(btn_removeStaff, "cell 0 6");
            }
            tabbedPane1.addTab("Bank Staff List", addStaffPanel);

            //======== modifyEmailPanel ========
            {
                modifyEmailPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[50:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]" +
                    "[]0" +
                    "[]0" +
                    "[100:n]" +
                    "[]"));

                //---- lbl_emailHost ----
                lbl_emailHost.setText("Email host");
                lbl_emailHost.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailHost, "cell 1 1");

                //---- tf_emailHost ----
                tf_emailHost.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_emailHost, "cell 2 1");

                //---- lbl_emailPort ----
                lbl_emailPort.setText("Email port");
                lbl_emailPort.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailPort, "cell 1 2");

                //---- tf_emailPort ----
                tf_emailPort.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_emailPort, "cell 2 2");

                //---- lbl_email ----
                lbl_email.setText("Email ");
                lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_email, "cell 1 3");

                //---- tf_email ----
                tf_email.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_email, "cell 2 3");

                //---- lbl_emailPwd ----
                lbl_emailPwd.setText("Password");
                lbl_emailPwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailPwd, "cell 1 4");

                //---- pf_emailPwd ----
                pf_emailPwd.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(pf_emailPwd, "cell 2 4");

                //---- lbl_emailConfirmPwd ----
                lbl_emailConfirmPwd.setText("Confirm password");
                lbl_emailConfirmPwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailConfirmPwd, "cell 1 5");

                //---- pf_emailConfirmPwd ----
                pf_emailConfirmPwd.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(pf_emailConfirmPwd, "cell 2 5");

                //---- btn_checkAvailability ----
                btn_checkAvailability.setText("Check Availability");
                btn_checkAvailability.setFont(btn_checkAvailability.getFont().deriveFont(btn_checkAvailability.getFont().getSize() + 4f));
                modifyEmailPanel.add(btn_checkAvailability, "cell 1 10");

                //---- btn_modify ----
                btn_modify.setText("Modify");
                btn_modify.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(btn_modify, "cell 2 10");
            }
            tabbedPane1.addTab("Modify System Email", modifyEmailPanel);
        }
        contentPane.add(tabbedPane1, "cell 0 0 2 3");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_signoutActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 1 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel addStaffPanel;
    private JTextField tf_search;
    private JButton btn_search;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btn_addStaff;
    private JButton btn_removeStaff;
    private JPanel modifyEmailPanel;
    private JLabel lbl_emailHost;
    private JTextField tf_emailHost;
    private JLabel lbl_emailPort;
    private JTextField tf_emailPort;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JLabel lbl_emailPwd;
    private JPasswordField pf_emailPwd;
    private JLabel lbl_emailConfirmPwd;
    private JPasswordField pf_emailConfirmPwd;
    private JButton btn_checkAvailability;
    private JButton btn_modify;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
