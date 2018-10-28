package service.impl;

import Const.SysMailTemplateType;
import org.junit.jupiter.api.Test;
import service.ISysEmailService;
import util.CardNumberGenerator;
import util.PINGenerator;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SysEmailServiceTest {
    ISysEmailService sysEmailService = SysEmailService.getInstance();

    @Test
    void sendMailInNewAccountSituation() {

        //format mail
        String mailTemplate = sysEmailService.getMailTemplate(SysMailTemplateType.NEW_ACCOUNT);

        String formatMail = MessageFormat.format(mailTemplate, "Tang");
        System.out.println(formatMail);

        assertDoesNotThrow(() -> sysEmailService.send("empathytxk@hotmail.com",
                "Nuclear Bank - Apply for new account successful",
                formatMail));
    }

    @Test
    void sendMailForNewUser() {
        PINGenerator pinGenerator = PINGenerator.getInstance();
        CardNumberGenerator cardNumberGenerator = CardNumberGenerator.getInstance();

        String PIN = String.valueOf(pinGenerator.generatePIN());
        String cardNum = String.valueOf(cardNumberGenerator.getCardNumber());

        String mailTemplate = sysEmailService.getMailTemplate(SysMailTemplateType.NEW_USER);

        String formatMail = MessageFormat.format(mailTemplate, "Hao", "1000000000", PIN ,"1000000000",cardNum);
        System.out.print(formatMail);

        assertDoesNotThrow(() -> sysEmailService.send("cherrymeteor@outlook.com",
                "Nuclear Bank - Apply for new user successful",
                formatMail));
    }

}