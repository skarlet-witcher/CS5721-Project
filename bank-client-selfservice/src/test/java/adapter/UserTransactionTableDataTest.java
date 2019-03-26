package adapter;

import Const.UserOperateType;
import model.UserTransactionModel;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTransactionTableDataTest {

    @Test
    void getDataVector() {
        List<UserTransactionModel> userTransactionModelList = new ArrayList<>();

        UserTransactionModel userTransactionModel = new UserTransactionModel();

        userTransactionModel.setOperation_type(UserOperateType.TRANSFER);
        userTransactionModel.setTransactionNum("201812101341148302525");
        userTransactionModel.setDetails("Transfer to xiangkai");
        userTransactionModel.setBalance(22233D);
        userTransactionModel.setAmounts(1500D);
        userTransactionModel.setDate(Timestamp.valueOf("1970-01-01 01:00:00"));

        userTransactionModelList.add(userTransactionModel);

        assertDoesNotThrow(() -> {
            UserTransactionTableData userTransactionTableData = new UserTransactionTableData(userTransactionModelList);

            userTransactionTableData.getDataVector();
        });
    }
}