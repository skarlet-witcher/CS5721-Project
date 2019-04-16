package service.impl.command_pattern;

import java.sql.Timestamp;

/*
    intent: Encapsulate a request as an object, thereby letting you parameterize clients with
    different requests, queue or log requests, and support undoable operations.
 */

/**
 * Command Interface: with execute() method which return a TimeStamp
 */
public interface CalculateExpiry {
    Timestamp execute();
}
