package service;

public interface ISysEmailService {
    void send(String toAddress, String subject, String body);

    String getMailTemplate(String mailType);
}
