package service.impl.command_pattern;

import java.sql.Timestamp;

public class YoungSaverAccCalculateExpiry implements CalculateExpiry{
    private Receiver receiver;
    public YoungSaverAccCalculateExpiry(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Timestamp execute() {
        return receiver.YoungSaverExpire();
    }
}
