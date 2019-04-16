package service.impl.method_template_pattern;

/**
 * A template class to check and apply different fees needed for each type of account.
 */

/*
    Intent: Define the skeleton of an algorithm in an operation, deferring somesteps to
            subclasses. Template Method lets subclasses redefinecertain steps of an algorithm
            without changing the algorithm'sstructure.
     Participants:
        · AbstractClass (Application)
            o defines abstract primitive operations that concretesubclasses define to implement steps of an algorithm.
            o implements a template method defining the skeleton of an algorithm.The template method calls primitive operations as well as operationsdefined in AbstractClass or those of other objects.
        · ConcreteClass (MyApplication)
            o implements the primitive operations to carry out subclass-specificsteps of the algorithm.
 */
public abstract class FeesTemplate {
    double fees;

    abstract double calculateQuarterlyMaintenanceFee();

    abstract double calculateOverdraftFee();

    public final double calculateFees() {
        fees = calculateQuarterlyMaintenanceFee();
        fees += calculateOverdraftFee();
        return fees;
    }
}
