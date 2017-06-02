package kttech.browser.ktbrowser.app;

import javax.inject.Singleton;

import kttech.browser.ktbrowser.activity.BrowserActivity;
import kttech.browser.ktbrowser.activity.ReadingActivity;
import kttech.browser.ktbrowser.activity.TabsManager;
import kttech.browser.ktbrowser.activity.ThemableBrowserActivity;
import kttech.browser.ktbrowser.activity.ThemableSettingsActivity;
import kttech.browser.ktbrowser.browser.BrowserPresenter;
import kttech.browser.ktbrowser.constant.BookmarkPage;
import kttech.browser.ktbrowser.constant.HistoryPage;
import kttech.browser.ktbrowser.constant.StartPage;
import kttech.browser.ktbrowser.database.history.HistoryDatabase;
import kttech.browser.ktbrowser.dialog.LightningDialogBuilder;
import kttech.browser.ktbrowser.download.LightningDownloadListener;
import kttech.browser.ktbrowser.fragment.BookmarkSettingsFragment;
import kttech.browser.ktbrowser.fragment.BookmarksFragment;
import kttech.browser.ktbrowser.fragment.DebugSettingsFragment;
import kttech.browser.ktbrowser.fragment.LightningPreferenceFragment;
import kttech.browser.ktbrowser.fragment.PrivacySettingsFragment;
import kttech.browser.ktbrowser.fragment.TabsFragment;
import kttech.browser.ktbrowser.search.SuggestionsAdapter;
import kttech.browser.ktbrowser.utils.ProxyUtils;
import kttech.browser.ktbrowser.view.LightningChromeClient;
import kttech.browser.ktbrowser.view.LightningView;
import kttech.browser.ktbrowser.view.LightningWebClient;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BrowserActivity activity);

    void inject(BookmarksFragment fragment);

    void inject(BookmarkSettingsFragment fragment);

    void inject(LightningDialogBuilder builder);

    void inject(TabsFragment fragment);

    void inject(LightningView lightningView);

    void inject(ThemableBrowserActivity activity);

    void inject(LightningPreferenceFragment fragment);

    void inject(BrowserApp app);

    void inject(ProxyUtils proxyUtils);

    void inject(ReadingActivity activity);

    void inject(LightningWebClient webClient);

    void inject(ThemableSettingsActivity activity);

    void inject(LightningDownloadListener listener);

    void inject(PrivacySettingsFragment fragment);

    void inject(StartPage startPage);

    void inject(HistoryPage historyPage);

    void inject(BookmarkPage bookmarkPage);

    void inject(BrowserPresenter presenter);

    void inject(TabsManager manager);

    void inject(DebugSettingsFragment fragment);

    void inject(SuggestionsAdapter suggestionsAdapter);

    void inject(LightningChromeClient chromeClient);

    HistoryDatabase historyDatabase();

}
