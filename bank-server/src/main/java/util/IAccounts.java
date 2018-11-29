package util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 11/11/2018.
 */
public interface IAccounts {
    public static final List<String> allAccounts= new ArrayList<String> (
            Arrays.asList("GoldenAccount","PersonalAccount","YoungSaversAccount","StudentAccount")
    );

    public boolean checkAgeValidity(Timestamp dob);
}
