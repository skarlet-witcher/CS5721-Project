package mediator;

import Const.UserOperateType;
import model.UserAccountModel;
import model.UserModel;
import model.UserTransactionModel;
import view.CustomerMainView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TransactionPage extends SubPage {

    List<UserTransactionModel> transactionModelList;
    UserModel userModel;


    public TransactionPage(MainMediator mediator, CustomerMainView view, List<UserTransactionModel> transactionModelList, UserModel userModel) {
        super(mediator, view);
        this.transactionModelList = transactionModelList;
        this.userModel = userModel;
    }

    @Override
    public void updatePage() {
        initTransactionTable();
    }

    private void initTransactionTable() {
        DefaultTableModel transactionListModel = (DefaultTableModel)this.view.table_transaction.getModel();
        clearTable(transactionListModel);
        if(this.userModel.getUserAccountList().size() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "No Account found.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(UserTransactionModel userTransactionModel: this.transactionModelList) {
            String date = userTransactionModel.getDate().toString();
            transactionListModel.addRow(new Object[]{
                    date.substring(0, date.indexOf(".")),
                    UserOperateType.getType(userTransactionModel.getOperation_type()),
                    userTransactionModel.getDetails(),
                    userTransactionModel.getAmounts(),
                    userTransactionModel.getBalance()
            });
        }
    }

    private void clearTable(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

}
