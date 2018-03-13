package com.jc.bookbrowser.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.jc.bookbrowser.BookBrowserApplication;
import com.jc.bookbrowser.R;
import com.jc.bookbrowser.view.activity.BaseActivity;

/**
 * Created by JC on 2018/01/19.
 */

public class UIHelper {

    public static Context getContext() {
        return BookBrowserApplication.getApplication();
    }

    public static void startActivity(Intent intent) {
        if (BaseActivity.activity == null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
        } else {
            BaseActivity.activity.startActivity(intent);
        }

    }

}
