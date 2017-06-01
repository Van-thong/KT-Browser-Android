package kttech.software.ktbrowser.app;

import javax.inject.Singleton;

import kttech.software.ktbrowser.activity.BrowserActivity;
import kttech.software.ktbrowser.activity.ReadingActivity;
import kttech.software.ktbrowser.activity.TabsManager;
import kttech.software.ktbrowser.activity.ThemableBrowserActivity;
import kttech.software.ktbrowser.activity.ThemableSettingsActivity;
import kttech.software.ktbrowser.browser.BrowserPresenter;
import kttech.software.ktbrowser.constant.BookmarkPage;
import kttech.software.ktbrowser.constant.HistoryPage;
import kttech.software.ktbrowser.constant.StartPage;
import kttech.software.ktbrowser.database.history.HistoryDatabase;
import kttech.software.ktbrowser.dialog.LightningDialogBuilder;
import kttech.software.ktbrowser.download.LightningDownloadListener;
import kttech.software.ktbrowser.fragment.BookmarkSettingsFragment;
import kttech.software.ktbrowser.fragment.BookmarksFragment;
import kttech.software.ktbrowser.fragment.DebugSettingsFragment;
import kttech.software.ktbrowser.fragment.LightningPreferenceFragment;
import kttech.software.ktbrowser.fragment.PrivacySettingsFragment;
import kttech.software.ktbrowser.fragment.TabsFragment;
import kttech.software.ktbrowser.search.SuggestionsAdapter;
import kttech.software.ktbrowser.utils.ProxyUtils;
import kttech.software.ktbrowser.view.LightningChromeClient;
import kttech.software.ktbrowser.view.LightningView;
import kttech.software.ktbrowser.view.LightningWebClient;
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
