package util;

import java.sql.Timestamp;

public class TimestampConvertHelper {

    public static Timestamp rpcToMysql(com.google.protobuf.Timestamp rpcTime) {
        Timestamp timestamp = new Timestamp(0);
        timestamp.setNanos(rpcTime.getNanos());
        return timestamp;
    }

    public static com.google.protobuf.Timestamp mysqlToRpc(Timestamp mysqlTime) {
        return com.google.protobuf.Timestamp.newBuilder()
                .setNanos(mysqlTime.getNanos()).build();
    }
}
