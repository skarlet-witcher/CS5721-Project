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
    public void updatePages(List<SubPage> subPages) {
        for(int i = 0; i< subPages.size(); i++) {
            subPages.get(i).updatePage();
        }
    }

    @Override
    public void initPages(SubPage subpage) {
        for(SubPage oneSubPage : subPages) {
            if(subpage.equals(oneSubPage)) {
                oneSubPage.initPage();
            }
        }
    }
}
