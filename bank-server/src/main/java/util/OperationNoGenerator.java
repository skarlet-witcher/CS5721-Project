package util;

import dao.impl.UserOperationHistoryDao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

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

    public String generateOperationNo() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available.
        String result = String.valueOf(year) + String.valueOf(month) + String.valueOf(day) +
                        String.valueOf(hour) + String.valueOf(minute) + String.valueOf(second) + String.valueOf(millis);

        for(int i = result.length(); i <= 20; i++) {
            int tempNum = RandomUtil.generateOneNum(0,9);
            result += String.valueOf(tempNum);
        }
        return result;
        /*
        long currentOperationNo = 1000000001L;
        Long operationNo = UserOperationHistoryDao.getInstance().getBiggestOperationNo();
        if (operationNo != null) {
            currentOperationNo = operationNo + 1L;
        }

        return currentOperationNo;
        */
    }
}
