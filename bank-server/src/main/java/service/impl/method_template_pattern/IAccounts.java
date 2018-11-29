package service.impl.method_template_pattern;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public interface IAccounts {
    List<String> allAccounts = new ArrayList<String>(
            Arrays.asList("GoldenAccount","PersonalAccount","YoungSaversAccount","StudentAccount")
    );

    boolean checkAgeValidity(Timestamp dob);
}
