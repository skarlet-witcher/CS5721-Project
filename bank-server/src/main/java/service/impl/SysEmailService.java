package service.impl;

import dao.ISysConfigDao;
import dao.impl.SysConfigDao;
import service.ISysEmailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SysEmailService implements ISysEmailService {
    private static SysEmailService instance = null;
    private ISysConfigDao sysConfigDao = SysConfigDao.getInstance();
    private String userName;
    private String password;
    private String host;
    private String port;

    private SysEmailService() {
        this.userName = sysConfigDao.getValueByKey("mail-account");
        this.password = sysConfigDao.getValueByKey("mail-password");
        this.host = sysConfigDao.getValueByKey("mail-host");
        this.port = sysConfigDao.getValueByKey("mail-port");
    }

    public static SysEmailService getInstance() {
        if (instance == null) {
            instance = new SysEmailService();
        }
        return instance;
    }

    public void send(String to, String subject, String body) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.model", userName);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(userName));
            InternetAddress toAddress = new InternetAddress(to);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userName, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public String getMailTemplate(String mailType) {
        return sysConfigDao.getValueByKey(mailType);
    }
}
