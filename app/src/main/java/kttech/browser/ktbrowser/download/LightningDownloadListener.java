/*
 * Copyright 2014 A.C.R. Development
 */
package kttech.browser.ktbrowser.download;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.format.Formatter;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;

import kttech.browser.ktbrowser.R;
import kttech.browser.ktbrowser.app.BrowserApp;
import kttech.browser.ktbrowser.dialog.BrowserDialog;
import kttech.browser.ktbrowser.preference.PreferenceManager;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;

import javax.inject.Inject;

public class LightningDownloadListener implements DownloadListener {

    private static final String TAG = "LightningDownloader";

    private final Activity mActivity;

    @Inject PreferenceManager mPreferenceManager;

    public LightningDownloadListener(Activity context) {
        BrowserApp.getAppComponent().inject(this);
        mActivity = context;
    }

    @Override
    public void onDownloadStart(final String url, final String userAgent,
                                final String contentDisposition, final String mimetype, final long contentLength) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(mActivity,
            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
            new PermissionsResultAction() {
                @Override
                public void onGranted() {
                    String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    DownloadHandler.onDownloadStart(mActivity, mPreferenceManager, url, userAgent,
                                        contentDisposition, mimetype);
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(mActivity); // dialog
                    String downloadSize;
                    if (contentLength > 0) {
                        downloadSize = Formatter.formatFileSize(mActivity, contentLength);
                    } else {
                        downloadSize = mActivity.getString(R.string.unknown_size);
                    }
                    String message = mActivity.getString(R.string.dialog_download, downloadSize);
                    Dialog dialog = builder.setTitle(fileName)
                        .setMessage(message)
                        .setPositiveButton(mActivity.getResources().getString(R.string.action_download),
                            dialogClickListener)
                        .setNegativeButton(mActivity.getResources().getString(R.string.action_cancel),
                            dialogClickListener).show();
                    BrowserDialog.setDialogSize(mActivity, dialog);
                    Log.i(TAG, "Downloading: " + fileName);
                }

                @Override
                public void onDenied(String permission) {
                    //TODO show message
                }
            });
    }
}
