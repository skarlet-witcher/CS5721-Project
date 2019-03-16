package adapter;

import Const.UserOperateType;
import model.UserTransactionModel;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

public class Adapter extends Adaptee implements TableData {

    public Adapter(List<UserTransactionModel> userTransactionModelList) {
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

    @Override
    public Vector getColumnIdentifiersVector() {
        Vector columnIdentifiers = new Vector();

        for(Field field: UserTransactionModel.class.getDeclaredFields()) {
            columnIdentifiers.add(field.getName());
        }
        return columnIdentifiers;
    }
}
