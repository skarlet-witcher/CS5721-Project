package adapter;

import model.UserPayeeModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPayeeTableDataTest {

    @Test
    void register() {
        UserPayeeTableData userPayeeTableData = new UserPayeeTableData();
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setIban("IE82BOFI23341000000001");
        userPayeeModel.setName("xiangkai");

        assertDoesNotThrow(() -> {
            userPayeeTableData.register(new String[]{"getIban", "getName"});
        });
    }

    @Test
    void setDataVector() {
        UserPayeeTableData userPayeeTableData = new UserPayeeTableData();
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setIban("IE82BOFI23341000000001");
        userPayeeModel.setName("xiangkai");
        userPayeeTableData.register(new String[]{"getIban", "getName"});


        assertDoesNotThrow(() -> {
            userPayeeTableData.setDataVector(userPayeeModel);
        });
    }
}