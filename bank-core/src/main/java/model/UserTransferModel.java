package model;

import java.util.ArrayList;
import java.util.List;

public class UserTransferModel implements Subject {
    private UserPayeeModel payee;
    private UserAccountModel account;
    private Integer currencyType;
    private Double amounts;
    private String postScript;
    private List<Observer> observers;

    public UserTransferModel() {
        observers = new ArrayList<>();
    }

    public void setAmounts(Double amounts) {
        this.amounts = amounts;
        updateAmounts();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.updateTransferPage(this);
        }
    }

    public UserPayeeModel getPayee() {
        return payee;
    }

    public void setPayee(UserPayeeModel payee) {
        this.payee = payee;
    }

    public UserAccountModel getAccount() {
        return account;
    }

    public void setAccount(UserAccountModel account) {
        this.account = account;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Double getAmounts() {
        return amounts;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
    }

    public void updateAmounts() {
        notifyObserver();
    }


}
