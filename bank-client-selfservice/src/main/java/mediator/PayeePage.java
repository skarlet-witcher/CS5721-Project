package mediator;

import model.UserModel;
import model.UserPayeeModel;
import view.CustomerMainView;

import javax.swing.table.DefaultTableModel;

public class PayeePage extends SubPage {

    private UserModel userModel;

    public PayeePage(MainMediator mediator, CustomerMainView view, UserModel userModel) {
        super(mediator, view);
        this.userModel = userModel;
    }

    @Override
    public void updatePage() {
        // init payee table
        DefaultTableModel payeeTableModel = (DefaultTableModel)this.view.table_payee_payeeList.getModel();
        clearTable(payeeTableModel);
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            payeeTableModel.addRow(new Object[]{
                    userPayeeModel.getIban(),
                    userPayeeModel.getName()
            });
        }
    }

    @Override
    public void initPage() {
        updatePage();
    }

    private void clearTable(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }
}
