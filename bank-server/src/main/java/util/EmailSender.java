package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private String USER_NAME = "USERNAME";  // GMail user name (just the part before "@gmail.com")
    private String PASSWORD = "PASSWORD"; // GMail password
    private String RECIPIENT = "";
    private static EmailSender emailSender = null;

    private EmailSender() {
        // TO DO - init USER_NAME and PASSWORD
    }

    public static EmailSender getInstance() {
        if(emailSender == null) {
            emailSender = new EmailSender();
        }
        return emailSender;
    }

    /*
    public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        sendFromGMail(from, pass, to, subject, body);
    }
    */

    public void sendFromGMail(String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
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
