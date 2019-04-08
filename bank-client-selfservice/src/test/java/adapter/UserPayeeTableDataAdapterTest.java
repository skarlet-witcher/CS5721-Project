package adapter;

import model.UserPayeeModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPayeeTableDataAdapterTest {

    @Test
    void register() {
        UserPayeeTableDataAdapter userPayeeTableDataAdapter = new UserPayeeTableDataAdapter();
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setIban("IE82BOFI23341000000001");
        userPayeeModel.setName("xiangkai");

        assertDoesNotThrow(() -> {
            userPayeeTableDataAdapter.register(new String[]{"getIban", "getName"});
        });
    }

    @Test
    void setDataVector() {
        UserPayeeTableDataAdapter userPayeeTableDataAdapter = new UserPayeeTableDataAdapter();
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setIban("IE82BOFI23341000000001");
        userPayeeModel.setName("xiangkai");
        userPayeeTableDataAdapter.register(new String[]{"getIban", "getName"});


        assertDoesNotThrow(() -> {
            userPayeeTableDataAdapter.convertData(userPayeeModel);
        });
    }
}