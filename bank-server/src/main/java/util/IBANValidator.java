package util;

import org.iban4j.Iban;
import org.iban4j.IbanUtil;

public class IBANValidator {
    private static IBANValidator ibanValidator = null;

    private IBANValidator() {
    }

    public static IBANValidator getInstance() {
        if(ibanValidator == null) {
            ibanValidator = new IBANValidator();
        }
        return ibanValidator;
    }

    public void validateIban(String iban) {
        IbanUtil.validate(iban);
    }
}
