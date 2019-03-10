package mediator;


import java.util.List;

public interface MainMediator {
        void addSubPage(SubPage subPage);
        void updatePages(List<SubPage> subPages);
        void initPages(SubPage subpage);
}
