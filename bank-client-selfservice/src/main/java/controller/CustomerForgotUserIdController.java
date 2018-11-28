package controller;

import model.UserForgotUserIdModel;
import service.impl.CustomerLoginService;
import util.JTextFieldLimit;
import view.CustomerForgotUserIdView;
import view.CustomerLoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.util.Calendar;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerForgotUserIdController implements BaseController {
    private CustomerForgotUserIdView view;

    public CustomerForgotUserIdController(CustomerForgotUserIdView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        initTextFields();
        run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    public void initTextFields() {
        this.view.tf_contactNum.setDocument(new JTextFieldLimit(12));
        this.view.tf_day.setDocument(new JTextFieldLimit(2));
        this.view.tf_month.setDocument(new JTextFieldLimit(2));
        this.view.tf_year.setDocument(new JTextFieldLimit(4));

        this.view.tf_year.setText("YYYY");
        this.view.tf_month.setText("MM");
        this.view.tf_day.setText("DD");
    }

    public void tf_dayFocusGained(FocusEvent e) {
        this.view.tf_day.selectAll();
    }

    public void tf_monthFocusGained(FocusEvent e) {
        this.view.tf_month.selectAll();
    }

    public void tf_yearFocusGained(FocusEvent e) {
        this.view.tf_year.selectAll();
    }

    public void btn_confirmActionPerformed(ActionEvent e) {
        // First Name validator
        if(this.view.tf_firstName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your first name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_firstName.grabFocus();
            return;
        } if(!this.view.tf_firstName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain characters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_firstName.grabFocus();
            return;
        }

        // Last name validator
        if(this.view.tf_lastName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your last name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_lastName.grabFocus();
            return;
        } if(!this.view.tf_lastName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain characters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_lastName.grabFocus();
            return;
        }

        // date of birth validator

        // day of dob validator
        if(this.view.tf_day.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your day of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_day.grabFocus();
            return;
        }
        if(!this.view.tf_day.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The day of the date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_day.grabFocus();
            return;
        }
        if(Integer.parseInt(this.view.tf_day.getText().trim()) > 31 || Integer.parseInt(this.view.tf_day.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of day of the date of birth should be 1 to 31",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_day.grabFocus();
            return;
        }
        if(this.view.tf_day.getText().trim().length() == 1) {
            this.view.tf_day.setText("0" + this.view.tf_day.getText());
        }

        // month of dob validator
        if(this.view.tf_month.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your month of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_month.grabFocus();
            return;
        }
        if(!this.view.tf_month.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The month of your date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_month.grabFocus();
            return;
        }
        if(Integer.parseInt(this.view.tf_month.getText().trim()) > 12 || Integer.parseInt(this.view.tf_month.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of month of the date of birth should be 1 to 12",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_month.grabFocus();
            return;
        }
        if(this.view.tf_month.getText().trim().length() == 1) {
            this.view.tf_month.setText("0" + this.view.tf_month.getText());
        }

        //  year of the date or birth validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(this.view.tf_year.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your year of the date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_year.grabFocus();
            return;
        } if(!this.view.tf_year.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "year of the date of brith should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_year.grabFocus();
            return;
        }
        if(this.view.tf_year.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be four digits",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_year.grabFocus();
            return;
        }
        if(Integer.parseInt(this.view.tf_year.getText().trim()) > currentYear) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be less or equal to current year",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_year.grabFocus();
            return;
        }

        // email field validator
        if(this.view.tf_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_email.grabFocus();
            return;
        }
        if(!this.view.tf_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_email.grabFocus();
            return;
        }

        // contact number validator
        if(this.view.tf_contactNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_contactNum.grabFocus();
            return;
        }
        if(!this.view.tf_contactNum.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_contactNum.grabFocus();
            return;

            // TO-DO forgot userId using model and service
            //
        }
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName= this.view.tf_lastName.getText().trim();
        String email= this.view.tf_email.getText();
        String contactNum= this.view.tf_contactNum.getText();
        System.out.println("Reaching here!!!");
        String birthDateText = this.view.tf_year.getText().trim()+"-"+
                this.view.tf_month.getText().trim()+"-"+this.view.tf_day.getText().trim()+" 00:00:00";
        //month and day with one digit
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        /*
        Calendar bdate= Calendar.getInstance();
        bdate.set(year,month,day);
        System.out.println("Printing all fields..."+firstName+" "+lastName+" "+bdate);
        Timestamp timestampBDate = new Timestamp(bdate.getTimeInMillis());
        */
        UserForgotUserIdModel userForgotUserIdModel = new UserForgotUserIdModel(firstName,lastName,birthDate,email,contactNum);
        try {
            CustomerLoginService.getInstance().requestForgotUserId(userForgotUserIdModel);
            JOptionPane.showMessageDialog(null,
                    "The UserId has been sent to your email.",
                    "Info Message",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null,
                    "Fail to request UserId due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerLoginView();
    }
}
