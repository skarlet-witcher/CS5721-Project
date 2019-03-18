package app;

import view.CustomerLoginView;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new CustomerLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
