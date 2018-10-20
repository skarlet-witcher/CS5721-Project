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
        generateKeyPad();
        generatePINField(2,3,6);
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void btn_1ActionPerformed(ActionEvent e) {
        inputPIN(btn_1.getText());
    }

    private void btn_2ActionPerformed(ActionEvent e) {
        inputPIN(btn_2.getText());
    }

    private void btn_3ActionPerformed(ActionEvent e) {
        inputPIN(btn_3.getText());
    }

    private void btn_4ActionPerformed(ActionEvent e) {
        inputPIN(btn_4.getText());
    }

    private void btn_5ActionPerformed(ActionEvent e) {
        inputPIN(btn_5.getText());
    }

    private void btn_6ActionPerformed(ActionEvent e) {
        inputPIN(btn_6.getText());
    }

    private void btn_7ActionPerformed(ActionEvent e) {
        inputPIN(btn_7.getText());
    }

    private void btn_8ActionPerformed(ActionEvent e) {
        inputPIN(btn_8.getText());
    }

    private void btn_9ActionPerformed(ActionEvent e) {
        inputPIN(btn_9.getText());
    }

    private void btn_10ActionPerformed(ActionEvent e) {
        inputPIN(btn_10.getText());
    }

    private void btn_backSpaceActionPerformed(ActionEvent e) {
        backSpacePIN();
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

    private JPasswordField emptyPasswordFieldCheckerForInput() {
        JPasswordField result = null;
        for (int i = 0; i < 3; i++) {
            if (passwordFieldsList.get(i).getPassword().length <= 0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    private JPasswordField passwordFieldCheckerForRemove() {
        JPasswordField result = null;
        for(int i = 2; i >= 0; i--) {
            if(passwordFieldsList.get(i).getPassword().length >0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    private void inputPIN(String str) {
        if(emptyPasswordFieldCheckerForInput()== null) {
            return;
        } else {
            emptyPasswordFieldCheckerForInput().setText(str);
        }

    }

    private void backSpacePIN() {
        if(passwordFieldCheckerForRemove()== null) return;
        passwordFieldCheckerForRemove().setText("");
    }

    private void generatePasswordField() {
        JPasswordField pf = new JPasswordField();
        pf.setMinimumSize(new Dimension(20,20));
        pf.setDocument(new JTextFieldLimit(1));
        pf.setEditable(false);
        getContentPane().add(pf, "cell 2 0");
        passwordFieldsList.add(pf);
    }

    private void generateLabel() {
        JLabel lbl = new JLabel("*");
        getContentPane().add(lbl, "cell 2 0");
    }

    private void generatePINField(int digit_1, int digit_2, int digit_3) {
        for(int i = 1; i <= 6; i++) {
            if( i == digit_1 || i == digit_2 || i == digit_3) {
               generatePasswordField();
            } else {
                generateLabel();
            }
        }
        pack();
    }

    private void generateKeyPad() {
        List<Integer> keyPadList = KeyPadGenerator.getInstance().getKeyPadArr();

        btn_1.setText(keyPadList.get(0).toString());
        btn_2.setText(keyPadList.get(1).toString());
        btn_3.setText(keyPadList.get(2).toString());
        btn_4.setText(keyPadList.get(3).toString());
        btn_5.setText(keyPadList.get(4).toString());
        btn_6.setText(keyPadList.get(5).toString());
        btn_7.setText(keyPadList.get(6).toString());
        btn_8.setText(keyPadList.get(7).toString());
        btn_9.setText(keyPadList.get(8).toString());
        btn_10.setText(keyPadList.get(9).toString());
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
