package kttech.browser.ktbrowser.view;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import kttech.browser.ktbrowser.utils.Utils;

class IconCacheTask implements Runnable {
    private final Uri uri;
    private final Bitmap icon;
    private final Application app;

    public IconCacheTask(final Uri uri, final Bitmap icon, final Application app) {
        this.uri = uri;
        this.icon = icon;
        this.app = app;
    }

    @Override
    public void run() {
        String hash = String.valueOf(uri.getHost().hashCode());
        FileOutputStream fos = null;
        try {
            File image = new File(app.getCacheDir(), hash + ".png");
            fos = new FileOutputStream(image);
            icon.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Utils.close(fos);
        }
    }
}
