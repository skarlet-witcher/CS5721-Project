package service.impl.command_pattern;


import java.sql.Timestamp;

/**
 * Invoker class: to instruct the Command to execute the request in respose to Expiry Date calculating event.
 * Method setCommand(Command): set a command to the class's property.
 * Method executeCommand(): to execute a command which is set by setCommand(Command) method.
 */
public class Invoker {

    //Command to set and execute
    CalculateExpiry command;

    public void setCommand(CalculateExpiry command) {
        this.command = command;
    }

    public Timestamp executeCommand() {
        return command.execute();
    }
}