package adapter;

import Const.UserOperateType;
import model.UserTransactionModel;

import java.util.List;
import java.util.Vector;

public class UserTransactionTableData extends UserTransactionData implements TableData {   // classic adapter for UserTransactionModel

    public UserTransactionTableData(List<UserTransactionModel> userTransactionModelList) {
        super(userTransactionModelList);
    }

    @Override
    public Vector getDataVector() {
        Vector dataVector = new Vector();

        for(UserTransactionModel userTransactionModel : this.getList()) {
            Vector rowVector = new Vector();
            rowVector.add(userTransactionModel.getDate().toString().substring(0, userTransactionModel.getDate().toString().indexOf(".")));
            rowVector.add(userTransactionModel.getDetails());
            rowVector.add(userTransactionModel.getAmounts());
            rowVector.add(userTransactionModel.getBalance());
            rowVector.add(userTransactionModel.getTransactionNum());
            rowVector.add(UserOperateType.getType(userTransactionModel.getOperation_type()));

            dataVector.add(rowVector);

        }
        return dataVector;
    }

}
