package util;

import dao.impl.SysConfigDao;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private String USER_NAME = "USERNAME";  // GMail model name (just the part before "@gmail.com")
    private String PASSWORD = "PASSWORD"; // GMail password
    private String HOST;
    private String PORT;
    private String RECIPIENT = "";
    private static EmailSender emailSender = null;

    private EmailSender() {
        this.USER_NAME = SysConfigDao.getInstance().getValueByKey("email");
        this.PASSWORD = SysConfigDao.getInstance().getValueByKey("password");
        this.HOST = SysConfigDao.getInstance().getValueByKey("host");
        this.PORT = SysConfigDao.getInstance().getValueByKey("port");
    }

    public static EmailSender getInstance() {
        if(emailSender == null) {
            emailSender = new EmailSender();
        }
        return emailSender;
    }


    public void sendFromGMail(String to, String subject, String body) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.model", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        String htmlMessage = "<html><p>Dear customer</p><p>" + body + "</p><p>Kind Regards</p><p>Nuclear bank team</p></html>";
        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress toAddress = new InternetAddress(to);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(subject);
            message.setContent(htmlMessage, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            // address Exception
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            // messages Exception
            me.printStackTrace();
        }
    }
}
