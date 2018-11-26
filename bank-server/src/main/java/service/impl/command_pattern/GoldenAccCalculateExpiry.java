package service.impl.command_pattern;

import java.sql.Timestamp;

public class GoldenAccCalculateExpiry implements CalculateExpiry {
    private Receiver receiver;

    public GoldenAccCalculateExpiry(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Timestamp execute() {
        return receiver.GoldenExpire();
    }
}