package mediator;

import Const.CardCurrencyType;
import model.UserAccountModel;
import model.UserModel;
import model.UserPayeeModel;
import util.JTextFieldLimit;
import view.CustomerMainView;

import javax.swing.*;

public class TransferPage extends SubPage {

    private UserModel userModel;

    public TransferPage(MainMediator mediator, CustomerMainView view, UserModel userModel) {
        super(mediator, view);
        this.userModel = userModel;
    }

    @Override
    public void updatePage() {
        initPayeeComboBox();
        initCurrency();
        initBalance();
        initAmounts();
        initPostscriptTextFieldLimit();
        initTransferPINField();
    }

    @Override
    public void initPage() {
        initPayeeComboBox();
        initAccountComboBox(this.view.cb_transfer_accountList);
        initCurrency();
        initBalance();
        initAmounts();
        initPostscriptTextFieldLimit();
        initTransferPINField();
    }

    private void initCurrency() {
        this.view.tf_transfer_currency.setText(CardCurrencyType.getCurrencyType(this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex()).getCurrencyType()));
    }

    private void initBalance() {
        this.view.tf_transfer_balance.setText(String.valueOf(this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex()).getBalance()));
    }

    private void initAccountComboBox(JComboBox accountComboBox) {
        accountComboBox.removeAllItems();
        if(this.userModel.getUserAccountList().size() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "No Account found in Transfer Page.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(UserAccountModel userAccountModel : this.userModel.getUserAccountList()) {
            accountComboBox.addItem(String.valueOf(userAccountModel.getAccountNum()));
        }
        accountComboBox.setSelectedIndex(0);

    }

    private void initPayeeComboBox() {
        this.view.cb_transfer_payeeList.removeAllItems();
        if(this.userModel.getUserPayeeList().size() <= 0) {
            this.view.cb_transfer_payeeList.addItem("No payee found");
            return;
        }
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            this.view.cb_transfer_payeeList.addItem(userPayeeModel.getName());
        }
    }

    private void initAmounts() {
        this.view.tf_transfer_amounts.setText("");
    }

    private void initTransferPINField() {
        this.view.pf_transfer_PIN.setText("");
    }

    private void initPostscriptTextFieldLimit() {
        this.view.tf_transfer_postScript.setDocument(new JTextFieldLimit(200));
    }
}
