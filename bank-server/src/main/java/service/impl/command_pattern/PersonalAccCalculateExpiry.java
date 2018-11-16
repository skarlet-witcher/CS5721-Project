package service.impl.command_pattern;

import java.sql.Timestamp;

public class PersonalAccCalculateExpiry implements CalculateExpiry {
    private Receiver receiver;

    public PersonalAccCalculateExpiry(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Timestamp execute() {
        return receiver.PersonalAccExpire();
    }
}