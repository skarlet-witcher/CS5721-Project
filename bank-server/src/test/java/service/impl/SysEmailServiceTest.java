package service.impl;

import Const.SysMailTemplateType;
import org.junit.jupiter.api.Test;
import service.ISysEmailService;

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
                "Apply for new account successful - Nuclear Bank",
                formatMail));
    }
}