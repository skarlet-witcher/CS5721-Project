package adapter;

import java.util.Vector;

/*
    intent: Define an interface for creating an object, but let subclasses decide which class
    to instantiate. Factory Method lets a class defer instantiation to subclasses.


 */

/*
    Target: defines the domain-specific interface that Client uses.
 */

public interface TableData {  // ITarget
    Vector getDataVector(); // request
}
