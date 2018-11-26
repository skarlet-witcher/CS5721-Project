package service.impl.command_pattern;


import java.sql.Timestamp;

public class  Invoker{
    public Timestamp executeCommand(CalculateExpiry calculateExpiry){
        return calculateExpiry.execute();
    }
}