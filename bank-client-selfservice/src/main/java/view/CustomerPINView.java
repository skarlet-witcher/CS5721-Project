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
    private JPasswordField pf_PIN_1;
    private JPasswordField pf_PIN_2;
    private JPasswordField pf_PIN_3;
    private JPasswordField pf_PIN_4;
    private JPasswordField pf_PIN_5;
    private JPasswordField pf_PIN_6;
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
    private List<Integer> keyPadList;
    private String windowType;

    public CustomerPINView(String type) {
        initComponents();
        generateKeyPad();
        initPasswordFieldList();
        initPasswordField();
        initWindowType(type);

    }

    private void btn_backActionPerformed(ActionEvent e) {
        if (windowType == "Payee") {
            this.dispose();
            new CustomerMainView().run();
        }
        if (windowType == "CustomerLogin") {
            this.dispose();
            new CustomerLoginView().run();
        }
    }

    private void btn_1ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(0).toString());
    }

    private void btn_2ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(1).toString());
    }

    private void btn_3ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(2).toString());
    }

    private void btn_4ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(3).toString());
    }

    private void btn_5ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(4).toString());
    }

    private void btn_6ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(5).toString());
    }

    private void btn_7ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(6).toString());
    }

    private void btn_8ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(7).toString());
    }

    private void btn_9ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(8).toString());
    }

    private void btn_10ActionPerformed(ActionEvent e) {
        inputPIN(keyPadList.get(9).toString());
    }

    private void btn_backSpaceActionPerformed(ActionEvent e) {
        if (passwordFieldCheckerForRemove() == null) return;
        passwordFieldCheckerForRemove().setText("");
    }

    private void button13ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_confirmActionPerformed(ActionEvent e) {
        // for test
        /*
        for(JPasswordField a : passwordFieldsList) {
            System.out.print(a.getPassword()[0] + " ");
        }
        System.out.println("");
        */
        this.dispose();
        new CustomerMainView().run();

    }

    private void pf_PIN_1PropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void pf_PIN_1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void pf_PIN_1CaretUpdate(CaretEvent e) {
    }

    private void initWindowType(String type) {
        this.windowType = type;
    }

    private void inputPIN(String str) {
        if (emptyPasswordFieldCheckerForInput() == null) return;
        emptyPasswordFieldCheckerForInput().setText(str);
    }

    private void initPasswordField() {
        pf_PIN_1.setDocument(new JTextFieldLimit(1));
        pf_PIN_2.setDocument(new JTextFieldLimit(1));
        pf_PIN_3.setDocument(new JTextFieldLimit(1));
        pf_PIN_4.setDocument(new JTextFieldLimit(1));
        pf_PIN_5.setDocument(new JTextFieldLimit(1));
        pf_PIN_6.setDocument(new JTextFieldLimit(1));

        List<Integer> accessList = PINFieldSetter.getInstance().setPINField();

        for (int i = 0; i < 6; i++) {
            if (accessList.get(i) == 1) {
                passwordFieldsList.get(i).setText("*");
                passwordFieldsList.get(i).setEnabled(false);
            }
        }
    }

    private void generateKeyPad() {
        keyPadList = KeyPadGenerator.getInstance().getKeyPadArr();

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

    private void initPasswordFieldList() {
        passwordFieldsList.add(pf_PIN_1);
        passwordFieldsList.add(pf_PIN_2);
        passwordFieldsList.add(pf_PIN_3);
        passwordFieldsList.add(pf_PIN_4);
        passwordFieldsList.add(pf_PIN_5);
        passwordFieldsList.add(pf_PIN_6);

    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private JPasswordField emptyPasswordFieldCheckerForInput() {
        JPasswordField result = null;
        for (int i = 0; i < 6; i++) {
            if (passwordFieldsList.get(i).isEnabled() == true &&
                    passwordFieldsList.get(i).getPassword().length <= 0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    private JPasswordField passwordFieldCheckerForRemove() {
        JPasswordField result = null;
        for (int i = 5; i >= 0; i--) {
            if (passwordFieldsList.get(i).isEnabled() == true &&
                    passwordFieldsList.get(i).getPassword().length > 0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_PIN = new JLabel();
        pf_PIN_1 = new JPasswordField();
        pf_PIN_2 = new JPasswordField();
        pf_PIN_3 = new JPasswordField();
        pf_PIN_4 = new JPasswordField();
        pf_PIN_5 = new JPasswordField();
        pf_PIN_6 = new JPasswordField();
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

        //---- pf_PIN_1 ----
        pf_PIN_1.setEditable(false);
        pf_PIN_1.setFocusable(false);
        pf_PIN_1.setRequestFocusEnabled(false);
        pf_PIN_1.setVerifyInputWhenFocusTarget(false);
        pf_PIN_1.setOpaque(false);
        pf_PIN_1.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                pf_PIN_1PropertyChange(e);
            }
        });
        pf_PIN_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pf_PIN_1ActionPerformed(e);
            }
        });
        pf_PIN_1.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                pf_PIN_1CaretUpdate(e);
            }
        });
        contentPane.add(pf_PIN_1, "cell 2 0");

        //---- pf_PIN_2 ----
        pf_PIN_2.setEditable(false);
        pf_PIN_2.setFocusable(false);
        pf_PIN_2.setRequestFocusEnabled(false);
        pf_PIN_2.setVerifyInputWhenFocusTarget(false);
        pf_PIN_2.setOpaque(false);
        contentPane.add(pf_PIN_2, "cell 2 0");

        //---- pf_PIN_3 ----
        pf_PIN_3.setEditable(false);
        pf_PIN_3.setFocusable(false);
        pf_PIN_3.setRequestFocusEnabled(false);
        pf_PIN_3.setVerifyInputWhenFocusTarget(false);
        pf_PIN_3.setOpaque(false);
        contentPane.add(pf_PIN_3, "cell 3 0");

        //---- pf_PIN_4 ----
        pf_PIN_4.setEditable(false);
        pf_PIN_4.setFocusable(false);
        pf_PIN_4.setRequestFocusEnabled(false);
        pf_PIN_4.setVerifyInputWhenFocusTarget(false);
        pf_PIN_4.setOpaque(false);
        contentPane.add(pf_PIN_4, "cell 3 0");

        //---- pf_PIN_5 ----
        pf_PIN_5.setEditable(false);
        pf_PIN_5.setFocusable(false);
        pf_PIN_5.setRequestFocusEnabled(false);
        pf_PIN_5.setVerifyInputWhenFocusTarget(false);
        pf_PIN_5.setOpaque(false);
        contentPane.add(pf_PIN_5, "cell 4 0");

        //---- pf_PIN_6 ----
        pf_PIN_6.setEditable(false);
        pf_PIN_6.setFocusable(false);
        pf_PIN_6.setRequestFocusEnabled(false);
        pf_PIN_6.setVerifyInputWhenFocusTarget(false);
        pf_PIN_6.setOpaque(false);
        contentPane.add(pf_PIN_6, "cell 4 0");

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
