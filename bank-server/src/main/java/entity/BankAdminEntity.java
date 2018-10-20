package entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_admin", schema = "bank_manage", catalog = "")
public class BankAdminEntity {
    private long id;
    private String username;
    private String password;
    private String emailHost;
    private String emailPort;
    private String emailAccount;
    private String emailPassword;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email_host", nullable = false, length = 255)
    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    @Basic
    @Column(name = "email_port", nullable = false, length = 255)
    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    @Basic
    @Column(name = "email_account", nullable = false, length = 255)
    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    @Basic
    @Column(name = "email_password", nullable = false, length = 255)
    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAdminEntity that = (BankAdminEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (emailHost != null ? !emailHost.equals(that.emailHost) : that.emailHost != null) return false;
        if (emailPort != null ? !emailPort.equals(that.emailPort) : that.emailPort != null) return false;
        if (emailAccount != null ? !emailAccount.equals(that.emailAccount) : that.emailAccount != null) return false;
        return emailPassword != null ? emailPassword.equals(that.emailPassword) : that.emailPassword == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emailHost != null ? emailHost.hashCode() : 0);
        result = 31 * result + (emailPort != null ? emailPort.hashCode() : 0);
        result = 31 * result + (emailAccount != null ? emailAccount.hashCode() : 0);
        result = 31 * result + (emailPassword != null ? emailPassword.hashCode() : 0);
        return result;
    }
}
