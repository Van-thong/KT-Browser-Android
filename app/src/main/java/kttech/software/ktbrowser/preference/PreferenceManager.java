package kttech.software.ktbrowser.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Singleton;

import kttech.software.ktbrowser.constant.Constants;
import kttech.software.ktbrowser.download.DownloadHandler;

@Singleton
public class PreferenceManager {

    private static final String PREFERENCES = "settings";
    @NonNull private final SharedPreferences mPrefs;

    @Inject
    PreferenceManager(@NonNull final Context context) {
        mPrefs = context.getSharedPreferences(PREFERENCES, 0);
    }

    @NonNull
    public Suggestion getSearchSuggestionChoice() {
        try {
            return Suggestion.valueOf(mPrefs.getString(Name.SEARCH_SUGGESTIONS, Suggestion.SUGGESTION_GOOGLE.name()));
        } catch (IllegalArgumentException ignored) {
            return Suggestion.SUGGESTION_NONE;
        }
    }

    public void setSearchSuggestionChoice(@NonNull Suggestion suggestion) {
        putString(Name.SEARCH_SUGGESTIONS, suggestion.name());
    }

    public boolean getBookmarksAndTabsSwapped() {
        return mPrefs.getBoolean(Name.SWAP_BOOKMARKS_AND_TABS, false);
    }

    public void setBookmarkAndTabsSwapped(boolean swap) {
        putBoolean(Name.SWAP_BOOKMARKS_AND_TABS, swap);
    }

    public boolean getAdBlockEnabled() {
        return mPrefs.getBoolean(Name.BLOCK_ADS, false);
    }

    public void setAdBlockEnabled(boolean enable) {
        putBoolean(Name.BLOCK_ADS, enable);
    }

    public boolean getBlockImagesEnabled() {
        return mPrefs.getBoolean(Name.BLOCK_IMAGES, false);
    }

    public void setBlockImagesEnabled(boolean enable) {
        putBoolean(Name.BLOCK_IMAGES, enable);
    }

    public boolean getBlockThirdPartyCookiesEnabled() {
        return mPrefs.getBoolean(Name.BLOCK_THIRD_PARTY, false);
    }

    public void setBlockThirdPartyCookiesEnabled(boolean enable) {
        putBoolean(Name.BLOCK_THIRD_PARTY, enable);
    }

    public boolean getCheckedForTor() {
        return mPrefs.getBoolean(Name.INITIAL_CHECK_FOR_TOR, false);
    }

    public void setCheckedForTor(boolean check) {
        putBoolean(Name.INITIAL_CHECK_FOR_TOR, check);
    }

    public boolean getCheckedForI2P() {
        return mPrefs.getBoolean(Name.INITIAL_CHECK_FOR_I2P, false);
    }

    public void setCheckedForI2P(boolean check) {
        putBoolean(Name.INITIAL_CHECK_FOR_I2P, check);
    }

    public boolean getClearCacheExit() {
        return mPrefs.getBoolean(Name.CLEAR_CACHE_EXIT, false);
    }

    public void setClearCacheExit(boolean enable) {
        putBoolean(Name.CLEAR_CACHE_EXIT, enable);
    }

    public boolean getClearCookiesExitEnabled() {
        return mPrefs.getBoolean(Name.CLEAR_COOKIES_EXIT, false);
    }

    public void setClearCookiesExitEnabled(boolean enable) {
        putBoolean(Name.CLEAR_COOKIES_EXIT, enable);
    }

    public boolean getClearWebStorageExitEnabled() {
        return mPrefs.getBoolean(Name.CLEAR_WEBSTORAGE_EXIT, false);
    }

    public void setClearWebStorageExitEnabled(boolean enable) {
        putBoolean(Name.CLEAR_WEBSTORAGE_EXIT, enable);
    }

    public boolean getClearHistoryExitEnabled() {
        return mPrefs.getBoolean(Name.CLEAR_HISTORY_EXIT, false);
    }

    public void setClearHistoryExitEnabled(boolean enable) {
        putBoolean(Name.CLEAR_HISTORY_EXIT, enable);
    }

    public boolean getColorModeEnabled() {
        return mPrefs.getBoolean(Name.ENABLE_COLOR_MODE, true);
    }

    public void setColorModeEnabled(boolean enable) {
        putBoolean(Name.ENABLE_COLOR_MODE, enable);
    }

    public boolean getCookiesEnabled() {
        return mPrefs.getBoolean(Name.COOKIES, true);
    }

    public void setCookiesEnabled(boolean enable) {
        putBoolean(Name.COOKIES, enable);
    }

    @NonNull
    public String getDownloadDirectory() {
        return mPrefs.getString(Name.DOWNLOAD_DIRECTORY, DownloadHandler.DEFAULT_DOWNLOAD_PATH);
    }

    public void setDownloadDirectory(@NonNull String directory) {
        putString(Name.DOWNLOAD_DIRECTORY, directory);
    }

    public int getFlashSupport() {
        return mPrefs.getInt(Name.ADOBE_FLASH_SUPPORT, 0);
    }

    public void setFlashSupport(int n) {
        putInt(Name.ADOBE_FLASH_SUPPORT, n);
    }

    public boolean getFullScreenEnabled() {
        return mPrefs.getBoolean(Name.FULL_SCREEN, false);
    }

    public void setFullScreenEnabled(boolean enable) {
        putBoolean(Name.FULL_SCREEN, enable);
    }

    public boolean getHideStatusBarEnabled() {
        return mPrefs.getBoolean(Name.HIDE_STATUS_BAR, false);
    }

    public void setHideStatusBarEnabled(boolean enable) {
        putBoolean(Name.HIDE_STATUS_BAR, enable);
    }

    @NonNull
    public String getHomepage() {
        return mPrefs.getString(Name.HOMEPAGE, Constants.SCHEME_HOMEPAGE);
    }

    public void setHomepage(@NonNull String homepage) {
        putString(Name.HOMEPAGE, homepage);
    }

    public boolean getIncognitoCookiesEnabled() {
        return mPrefs.getBoolean(Name.INCOGNITO_COOKIES, false);
    }

    public void setIncognitoCookiesEnabled(boolean enable) {
        putBoolean(Name.INCOGNITO_COOKIES, enable);
    }

    public boolean getInvertColors() {
        return mPrefs.getBoolean(Name.INVERT_COLORS, false);
    }

    public void setInvertColors(boolean enable) {
        putBoolean(Name.INVERT_COLORS, enable);
    }

    public boolean getJavaScriptEnabled() {
        return mPrefs.getBoolean(Name.JAVASCRIPT, true);
    }

    public void setJavaScriptEnabled(boolean enable) {
        putBoolean(Name.JAVASCRIPT, enable);
    }

    public boolean getLocationEnabled() {
        return mPrefs.getBoolean(Name.LOCATION, false);
    }

    public void setLocationEnabled(boolean enable) {
        putBoolean(Name.LOCATION, enable);
    }

    public boolean getOverviewModeEnabled() {
        return mPrefs.getBoolean(Name.OVERVIEW_MODE, true);
    }

    public void setOverviewModeEnabled(boolean enable) {
        putBoolean(Name.OVERVIEW_MODE, enable);
    }

    public boolean getPopupsEnabled() {
        return mPrefs.getBoolean(Name.POPUPS, true);
    }

    public void setPopupsEnabled(boolean enable) {
        putBoolean(Name.POPUPS, enable);
    }

    @NonNull
    public String getProxyHost() {
        return mPrefs.getString(Name.USE_PROXY_HOST, "localhost");
    }

    public void setProxyHost(@NonNull String proxyHost) {
        putString(Name.USE_PROXY_HOST, proxyHost);
    }

    public int getProxyPort() {
        return mPrefs.getInt(Name.USE_PROXY_PORT, 8118);
    }

    public void setProxyPort(int proxyPort) {
        putInt(Name.USE_PROXY_PORT, proxyPort);
    }

    public int getReadingTextSize() {
        return mPrefs.getInt(Name.READING_TEXT_SIZE, 2);
    }

    public void setReadingTextSize(int size) {
        putInt(Name.READING_TEXT_SIZE, size);
    }

    public int getRenderingMode() {
        return mPrefs.getInt(Name.RENDERING_MODE, 0);
    }

    public void setRenderingMode(int mode) {
        putInt(Name.RENDERING_MODE, mode);
    }

    public boolean getRestoreLostTabsEnabled() {
        return mPrefs.getBoolean(Name.RESTORE_LOST_TABS, true);
    }

    public void setRestoreLostTabsEnabled(boolean enable) {
        putBoolean(Name.RESTORE_LOST_TABS, enable);
    }

    @Nullable
    public String getSavedUrl() {
        return mPrefs.getString(Name.SAVE_URL, null);
    }

    public void setSavedUrl(@Nullable String url) {
        putString(Name.SAVE_URL, url);
    }

    public boolean getSavePasswordsEnabled() {
        return mPrefs.getBoolean(Name.SAVE_PASSWORDS, true);
    }

    public void setSavePasswordsEnabled(boolean enable) {
        putBoolean(Name.SAVE_PASSWORDS, enable);
    }

    public int getSearchChoice() {
        return mPrefs.getInt(Name.SEARCH, 1);
    }

    public void setSearchChoice(int choice) {
        putInt(Name.SEARCH, choice);
    }

    @NonNull
    public String getSearchUrl() {
        return mPrefs.getString(Name.SEARCH_URL, Constants.GOOGLE_SEARCH);
    }

    public void setSearchUrl(@NonNull String url) {
        putString(Name.SEARCH_URL, url);
    }

    public boolean getTextReflowEnabled() {
        return mPrefs.getBoolean(Name.TEXT_REFLOW, false);
    }

    public void setTextReflowEnabled(boolean enable) {
        putBoolean(Name.TEXT_REFLOW, enable);
    }

    public int getTextSize() {
        return mPrefs.getInt(Name.TEXT_SIZE, 3);
    }

    public void setTextSize(int size) {
        putInt(Name.TEXT_SIZE, size);
    }

    public int getUrlBoxContentChoice() {
        return mPrefs.getInt(Name.URL_BOX_CONTENTS, 0);
    }

    public void setUrlBoxContentChoice(int choice) {
        putInt(Name.URL_BOX_CONTENTS, choice);
    }

    public int getUseTheme() {
        return mPrefs.getInt(Name.THEME, 0);
    }

    public void setUseTheme(int theme) {
        putInt(Name.THEME, theme);
    }

    public boolean getUseProxy() {
        return mPrefs.getBoolean(Name.USE_PROXY, false);
    }

    @Constants.PROXY
    public int getProxyChoice() {
        @Constants.PROXY int proxy = mPrefs.getInt(Name.PROXY_CHOICE, Constants.NO_PROXY);
        switch (proxy) {
            case Constants.NO_PROXY:
            case Constants.PROXY_ORBOT:
            case Constants.PROXY_I2P:
            case Constants.PROXY_MANUAL:
                return proxy;
            default:
                return Constants.NO_PROXY;
        }
    }

    /**
     * Valid choices:
     * <ul>
     * <li>{@link Constants#NO_PROXY}</li>
     * <li>{@link Constants#PROXY_ORBOT}</li>
     * <li>{@link Constants#PROXY_I2P}</li>
     * </ul>
     *
     * @param choice the proxy to use.
     */
    public void setProxyChoice(@Constants.PROXY int choice) {
        putBoolean(Name.USE_PROXY, choice != Constants.NO_PROXY);
        putInt(Name.PROXY_CHOICE, choice);
    }

    public int getUserAgentChoice() {
        return mPrefs.getInt(Name.USER_AGENT, 1);
    }

    public void setUserAgentChoice(int choice) {
        putInt(Name.USER_AGENT, choice);
    }

    @Nullable
    public String getUserAgentString(@Nullable String def) {
        return mPrefs.getString(Name.USER_AGENT_STRING, def);
    }

    public boolean getUseWideViewportEnabled() {
        return mPrefs.getBoolean(Name.USE_WIDE_VIEWPORT, true);
    }

    public void setUseWideViewportEnabled(boolean enable) {
        putBoolean(Name.USE_WIDE_VIEWPORT, enable);
    }

    @NonNull
    public String getTextEncoding() {
        return mPrefs.getString(Name.TEXT_ENCODING, Constants.DEFAULT_ENCODING);
    }

    public void setTextEncoding(@NonNull String encoding) {
        putString(Name.TEXT_ENCODING, encoding);
    }

    public boolean getShowTabsInDrawer(boolean defaultValue) {
        return mPrefs.getBoolean(Name.SHOW_TABS_IN_DRAWER, defaultValue);
    }

    public boolean getDoNotTrackEnabled() {
        return mPrefs.getBoolean(Name.DO_NOT_TRACK, false);
    }

    public void setDoNotTrackEnabled(boolean doNotTrack) {
        putBoolean(Name.DO_NOT_TRACK, doNotTrack);
    }

    public boolean getRemoveIdentifyingHeadersEnabled() {
        return mPrefs.getBoolean(Name.IDENTIFYING_HEADERS, false);
    }

    public void setRemoveIdentifyingHeadersEnabled(boolean enabled) {
        putBoolean(Name.IDENTIFYING_HEADERS, enabled);
    }

    private void putBoolean(@NonNull String name, boolean value) {
        mPrefs.edit().putBoolean(name, value).apply();
    }

    private void putInt(@NonNull String name, int value) {
        mPrefs.edit().putInt(name, value).apply();
    }

    private void putString(@NonNull String name, @Nullable String value) {
        mPrefs.edit().putString(name, value).apply();
    }

    public void setShowTabsInDrawer(boolean show) {
        putBoolean(Name.SHOW_TABS_IN_DRAWER, show);
    }

    public boolean getUseLeakCanary() {
        return mPrefs.getBoolean(Name.LEAK_CANARY, false);
    }

    public void setUseLeakCanary(boolean useLeakCanary) {
        putBoolean(Name.LEAK_CANARY, useLeakCanary);
    }

    public void setUserAgentString(@Nullable String agent) {
        putString(Name.USER_AGENT_STRING, agent);
    }

    public enum Suggestion {
        SUGGESTION_GOOGLE,
        SUGGESTION_DUCK,
        SUGGESTION_NONE
    }

    private static class Name {
        static final String ADOBE_FLASH_SUPPORT = "enableflash";
        static final String BLOCK_ADS = "AdBlock";
        static final String BLOCK_IMAGES = "blockimages";
        static final String CLEAR_CACHE_EXIT = "cache";
        static final String COOKIES = "cookies";
        static final String DOWNLOAD_DIRECTORY = "downloadLocation";
        static final String FULL_SCREEN = "fullscreen";
        static final String HIDE_STATUS_BAR = "hidestatus";
        static final String HOMEPAGE = "home";
        static final String INCOGNITO_COOKIES = "incognitocookies";
        static final String JAVASCRIPT = "java";
        static final String LOCATION = "location";
        static final String OVERVIEW_MODE = "overviewmode";
        static final String POPUPS = "newwindows";
        static final String RESTORE_LOST_TABS = "restoreclosed";
        static final String SAVE_PASSWORDS = "passwords";
        static final String SEARCH = "search";
        static final String SEARCH_URL = "searchurl";
        static final String TEXT_REFLOW = "textreflow";
        static final String TEXT_SIZE = "textsize";
        static final String USE_WIDE_VIEWPORT = "wideviewport";
        static final String USER_AGENT = "agentchoose";
        static final String USER_AGENT_STRING = "userAgentString";
        static final String CLEAR_HISTORY_EXIT = "clearHistoryExit";
        static final String CLEAR_COOKIES_EXIT = "clearCookiesExit";
        static final String SAVE_URL = "saveUrl";
        static final String RENDERING_MODE = "renderMode";
        static final String BLOCK_THIRD_PARTY = "thirdParty";
        static final String ENABLE_COLOR_MODE = "colorMode";
        static final String URL_BOX_CONTENTS = "urlContent";
        static final String INVERT_COLORS = "invertColors";
        static final String READING_TEXT_SIZE = "readingTextSize";
        static final String THEME = "Theme";
        static final String TEXT_ENCODING = "textEncoding";
        static final String CLEAR_WEBSTORAGE_EXIT = "clearWebStorageExit";
        static final String SHOW_TABS_IN_DRAWER = "showTabsInDrawer";
        static final String DO_NOT_TRACK = "doNotTrack";
        static final String IDENTIFYING_HEADERS = "removeIdentifyingHeaders";
        static final String SWAP_BOOKMARKS_AND_TABS = "swapBookmarksAndTabs";
        static final String SEARCH_SUGGESTIONS = "searchSuggestions";

        static final String USE_PROXY = "useProxy";
        static final String PROXY_CHOICE = "proxyChoice";
        static final String USE_PROXY_HOST = "useProxyHost";
        static final String USE_PROXY_PORT = "useProxyPort";
        static final String INITIAL_CHECK_FOR_TOR = "checkForTor";
        static final String INITIAL_CHECK_FOR_I2P = "checkForI2P";

        static final String LEAK_CANARY = "leakCanary";
    }
}
