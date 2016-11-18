package kttech.software.ktbrowser.app;

import javax.inject.Singleton;

import dagger.Component;
import kttech.software.ktbrowser.activity.BrowserActivity;
import kttech.software.ktbrowser.activity.ReadingActivity;
import kttech.software.ktbrowser.activity.TabsManager;
import kttech.software.ktbrowser.activity.ThemableBrowserActivity;
import kttech.software.ktbrowser.activity.ThemableSettingsActivity;
import kttech.software.ktbrowser.browser.BrowserPresenter;
import kttech.software.ktbrowser.constant.StartPage;
import kttech.software.ktbrowser.dialog.LightningDialogBuilder;
import kttech.software.ktbrowser.download.LightningDownloadListener;
import kttech.software.ktbrowser.fragment.BookmarkSettingsFragment;
import kttech.software.ktbrowser.fragment.BookmarksFragment;
import kttech.software.ktbrowser.fragment.DebugSettingsFragment;
import kttech.software.ktbrowser.fragment.LightningPreferenceFragment;
import kttech.software.ktbrowser.fragment.PrivacySettingsFragment;
import kttech.software.ktbrowser.fragment.TabsFragment;
import kttech.software.ktbrowser.search.SuggestionsAdapter;
import kttech.software.ktbrowser.utils.AdBlock;
import kttech.software.ktbrowser.utils.ProxyUtils;
import kttech.software.ktbrowser.view.LightningView;
import kttech.software.ktbrowser.view.LightningWebClient;

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

    void inject(AdBlock adBlock);

    void inject(LightningDownloadListener listener);

    void inject(PrivacySettingsFragment fragment);

    void inject(StartPage startPage);

    void inject(BrowserPresenter presenter);

    void inject(TabsManager manager);

    void inject(DebugSettingsFragment fragment);

    void inject(SuggestionsAdapter suggestionsAdapter);

}
