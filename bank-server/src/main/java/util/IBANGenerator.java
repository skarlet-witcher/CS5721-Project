package util;

import dao.impl.UserAccountDao;
import entity.UserAccountEntity;
import org.iban4j.CountryCode;
import org.iban4j.Iban;

import java.util.List;

public class IBANGenerator {
    private static IBANGenerator ibanGenerator = null;

    private IBANGenerator() {

    }

    public static IBANGenerator getInstance() {
        if(ibanGenerator == null) {
            ibanGenerator = new IBANGenerator();
        }
        return ibanGenerator;
    }

    public String generateIBAN(long accountNumber) {
        List<UserAccountEntity> userAccount = UserAccountDao.getInstance().getUserAccountByAccountNumber(accountNumber);
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.IE)
                .bankCode("BOFI")
                .branchCode("2334")
                .accountNumber(String.valueOf(userAccount.get(0).getAccountNumber()))
                .build();
        return iban.toString();
    }
}
