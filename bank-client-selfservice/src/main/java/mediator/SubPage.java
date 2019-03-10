package mediator;

import model.UserAccountModel;
import view.CustomerMainView;

import javax.swing.*;

public abstract class SubPage {
    protected MainMediator mediator;
    protected CustomerMainView view;

    public SubPage(MainMediator mediator, CustomerMainView view) {
        this.mediator = mediator;
        this.view = view;
    }

    public abstract void updatePage();

    public abstract void initPage();

}
