package service.impl.command_pattern;

import java.sql.Timestamp;


/**
 * Command Interface: with execute() method which return a TimeStamp
 */
public interface CalculateExpiry {
    Timestamp execute();
}
