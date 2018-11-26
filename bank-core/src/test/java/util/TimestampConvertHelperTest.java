package util;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

class TimestampConvertHelperTest {

    @Test
    void timeConvert() {

        Calendar date = new GregorianCalendar(5555, Calendar.JULY, 3);
        System.out.println(date.get(Calendar.YEAR));

        com.google.protobuf.Timestamp timestamp = TimestampConvertHelper.mysqlToRpc(new Timestamp(date.getTimeInMillis()));

        System.out.println(timestamp);

        Timestamp sqlTime = TimestampConvertHelper.rpcToMysql(timestamp);

        System.out.println(sqlTime);


    }

}