package model;

public class UserPayeeModel {
    private Long payee_pk;
    private String name;
    private String iban;
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPayee_pk() {
        return payee_pk;
    }

    public void setPayee_pk(Long payee_pk) {
        this.payee_pk = payee_pk;
    }
}
