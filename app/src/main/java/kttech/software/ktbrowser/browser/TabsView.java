package kttech.software.ktbrowser.browser;

public interface TabsView {

    void tabAdded();

    void tabRemoved(int position);

    void tabChanged(int position);

    void tabsInitialized();
}
