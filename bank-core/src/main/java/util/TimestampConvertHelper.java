package util;

import com.google.protobuf.util.Timestamps;

import java.sql.Timestamp;

public class TimestampConvertHelper {

    public static Timestamp rpcToMysql(com.google.protobuf.Timestamp rpcTime) {
        return new Timestamp(rpcTime.getSeconds() * 1000L);
    }

    public static com.google.protobuf.Timestamp mysqlToRpc(Timestamp mysqlTime) {
        return Timestamps.fromMillis(mysqlTime.getTime());
    }
}
