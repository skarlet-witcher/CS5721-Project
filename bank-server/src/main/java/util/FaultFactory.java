package util;

public class FaultFactory {
    public static Exception throwFaultException(String description) {
        return new Exception(description);
    }

    public static Exception throwFaultException() {
        return new Exception();
    }

}
