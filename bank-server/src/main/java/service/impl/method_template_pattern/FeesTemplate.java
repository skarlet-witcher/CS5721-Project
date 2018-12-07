package service.impl.method_template_pattern;

/**
 * A template class to check and apply different fees needed for each type of account.
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
