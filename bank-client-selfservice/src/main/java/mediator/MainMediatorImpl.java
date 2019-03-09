package mediator;

import java.util.ArrayList;
import java.util.List;

public class MainMediatorImpl implements MainMediator {

    private List<SubPage> subPages;

    public MainMediatorImpl() {
        this.subPages = new ArrayList<>();
    }

    @Override
    public void addSubPage(SubPage subPage) {
        this.subPages.add(subPage);
    }

    @Override
    public void updatePages() {
        for(SubPage subPage :  subPages) {
            subPage.updatePage();
        }
    }
}
