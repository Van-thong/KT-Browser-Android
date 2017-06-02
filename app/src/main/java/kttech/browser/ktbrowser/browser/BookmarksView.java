package kttech.browser.ktbrowser.browser;

import android.support.annotation.NonNull;

import kttech.browser.ktbrowser.database.HistoryItem;

public interface BookmarksView {

    void navigateBack();

    void handleUpdatedUrl(@NonNull String url);

    void handleBookmarkDeleted(@NonNull HistoryItem item);

}
