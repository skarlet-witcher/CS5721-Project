package util;

import dao.impl.UserOperationHistoryDao;

public class OperationNoGenerator {
    private static OperationNoGenerator operationNoGenerator = null;

    private OperationNoGenerator() {

    }

    public static OperationNoGenerator getInstance() {
        if(operationNoGenerator == null) {
            operationNoGenerator = new OperationNoGenerator();
        }
        return operationNoGenerator;
    }

    public long generateOperationNo() {
        long currentOperationNo = 1000000001L;
        Long operationNo = UserOperationHistoryDao.getInstance().getBiggestOperationNo();
        if (operationNo != null) {
            currentOperationNo = operationNo + 1L;
        }

        return currentOperationNo;
    }
}
