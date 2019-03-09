package mediator;

import Const.CardCurrencyType;
import Const.UserAccountType;
import Const.UserStatusType;
import model.UserAccountModel;
import model.UserModel;
import view.CustomerMainView;

import javax.swing.table.DefaultTableModel;

public class HomePage extends SubPage {

    private UserModel userModel;

    private UserAccountModel accountModel;

    public HomePage(MainMediator mediator, CustomerMainView view, UserModel userModel) {
        super(mediator, view);
        this.userModel = userModel;
    }


    @Override
    public void updatePage() {

        // update title
        String lastLoginTime = this.userModel.getLastLoginTime().toString();
        this.view.lbl_nameField.setText(this.userModel.getFirstName());
        this.view.lbl_lastLoginTime.setText(lastLoginTime.substring(0, lastLoginTime.indexOf(".")));

        // update account table
        DefaultTableModel accountListModel = (DefaultTableModel)this.view.table_home_accountTable.getModel();
        clearTable(accountListModel);
        for(UserAccountModel Account: this.userModel.getUserAccountList()) {
            accountListModel.addRow(new Object[]{
                    Account.getAccountNum(),
                    UserAccountType.getTypeName(Account.getAccountType()),
                    CardCurrencyType.getCurrencyType(Account.getCurrencyType()),
                    Account.getBalance(),
                    UserStatusType.getStatusType(Account.getStatus())});
        }
    }

    private void clearTable(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }
}
