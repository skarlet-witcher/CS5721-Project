package service.impl.command_pattern;

import java.sql.Timestamp;

/**
 * Concrete command class
 * Specify the binding between a Receiver and an action to be done by the Receiver
 * The action here is to calcute the expiry date for Golden Account
 */
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