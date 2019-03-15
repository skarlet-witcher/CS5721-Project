package adapter;

import Const.AccountCurrencyType;
import Const.CardCurrencyType;
import Const.UserOperateType;
import model.UserTransactionModel;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

public class Adapter extends Adaptee implements ITarget  {

    public Runnable getDataVectorReq;
    public Runnable getColumnIdentifierReq;

    public Adapter(List<UserTransactionModel> userTransactionModelList) {
        super(userTransactionModelList);
    }

    // pluggable adatper?
    public Adapter(Runnable r, Runnable r2) {
        getDataVectorReq = r;
        getColumnIdentifierReq = r2;
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
