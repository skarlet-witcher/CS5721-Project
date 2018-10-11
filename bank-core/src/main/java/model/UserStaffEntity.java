package model;

import javax.persistence.*;

@Entity
@Table(name = "user_staff", schema = "bank_manage", catalog = "")
public class UserStaffEntity {
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 32)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 32)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStaffEntity that = (UserStaffEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
