package adapter;

import java.util.Vector;

/*
    intent: Convert the interface of a class into another interface clients expect. Adapter
            lets classes work together that couldn't otherwise because of incompatible
            interfaces.


 */

/*
    Target: defines the domain-specific interface that Client uses.
 */

public interface TableData {  // ITarget
    Vector getDataVector(); // request
}
