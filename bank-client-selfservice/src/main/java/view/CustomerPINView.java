/*
 * Created by JFormDesigner on Sun Oct 14 19:47:04 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;
import util.KeyPadGenerator;
import util.PINFieldSetter;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangkai22
 */
public class CustomerPINView extends JFrame {
    List<JPasswordField> passwordFieldsList = new ArrayList<JPasswordField>();
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_PIN;
    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_4;
    private JButton btn_5;
    private JButton btn_6;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;
    private JButton btn_10;
    private JButton btn_backSpace;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public CustomerPINView() {
        initComponents();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void btn_1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_5ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_6ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_8ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_9ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_10ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_backSpaceActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_confirmActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_backActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_PIN = new JLabel();
        btn_1 = new JButton();
        btn_2 = new JButton();
        btn_3 = new JButton();
        btn_4 = new JButton();
        btn_5 = new JButton();
        btn_6 = new JButton();
        btn_7 = new JButton();
        btn_8 = new JButton();
        btn_9 = new JButton();
        btn_10 = new JButton();
        btn_backSpace = new JButton();
        btn_confirm = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Customer PIN View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[5:n,grow,fill]" +
            "[fill]" +
            "[40:n,fill]" +
            "[40:n,fill]" +
            "[40:n,fill]" +
            "[5:n,grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[5:n,grow,fill]"));

        //---- lbl_PIN ----
        lbl_PIN.setText("PIN: ");
        contentPane.add(lbl_PIN, "cell 1 0");

        //---- btn_1 ----
        btn_1.setText("text");
        btn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_1ActionPerformed(e);
            }
        });
        contentPane.add(btn_1, "cell 2 1");

        //---- btn_2 ----
        btn_2.setText("text");
        btn_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_2ActionPerformed(e);
                btn_2ActionPerformed(e);
            }
        });
        contentPane.add(btn_2, "cell 3 1");

        //---- btn_3 ----
        btn_3.setText("text");
        btn_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_3ActionPerformed(e);
            }
        });
        contentPane.add(btn_3, "cell 4 1");

        //---- btn_4 ----
        btn_4.setText("text");
        btn_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_4ActionPerformed(e);
            }
        });
        contentPane.add(btn_4, "cell 2 2");

        //---- btn_5 ----
        btn_5.setText("text");
        btn_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_5ActionPerformed(e);
            }
        });
        contentPane.add(btn_5, "cell 3 2");

        //---- btn_6 ----
        btn_6.setText("text");
        btn_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_6ActionPerformed(e);
            }
        });
        contentPane.add(btn_6, "cell 4 2");

        //---- btn_7 ----
        btn_7.setText("text");
        btn_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_7ActionPerformed(e);
            }
        });
        contentPane.add(btn_7, "cell 2 3");

        //---- btn_8 ----
        btn_8.setText("text");
        btn_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_8ActionPerformed(e);
            }
        });
        contentPane.add(btn_8, "cell 3 3");

        //---- btn_9 ----
        btn_9.setText("text");
        btn_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_9ActionPerformed(e);
            }
        });
        contentPane.add(btn_9, "cell 4 3");

        //---- btn_10 ----
        btn_10.setText("text");
        btn_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_10ActionPerformed(e);
            }
        });
        contentPane.add(btn_10, "cell 2 4 2 1");

        //---- btn_backSpace ----
        btn_backSpace.setText("Backspace");
        btn_backSpace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backSpaceActionPerformed(e);
            }
        });
        contentPane.add(btn_backSpace, "cell 4 4");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_confirmActionPerformed(e);
            }
        });
        contentPane.add(btn_confirm, "cell 2 6 3 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button13ActionPerformed(e);
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 2 6 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
