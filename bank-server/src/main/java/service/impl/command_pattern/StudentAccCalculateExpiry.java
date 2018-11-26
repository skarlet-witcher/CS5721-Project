package service.impl.command_pattern;


import java.sql.Timestamp;

public class StudentAccCalculateExpiry implements CalculateExpiry {
    private Receiver receiver;

    public StudentAccCalculateExpiry(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Timestamp execute() {
        return receiver.StudentAccExpire();
    }
}