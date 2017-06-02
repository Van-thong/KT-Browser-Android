package kttech.software.ktbrowser.browser;

import android.support.annotation.NonNull;

import kttech.software.ktbrowser.database.HistoryItem;

public interface BookmarksView {

    void navigateBack();

    void handleUpdatedUrl(@NonNull String url);

    void handleBookmarkDeleted(@NonNull HistoryItem item);

}
