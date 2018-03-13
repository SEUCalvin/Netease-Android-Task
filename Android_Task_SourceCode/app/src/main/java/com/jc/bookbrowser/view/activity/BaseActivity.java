package com.jc.bookbrowser.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.jc.bookbrowser.BookBrowserApplication;
import com.jc.bookbrowser.R;
import com.jc.bookbrowser.utils.UIHelper;
import com.orhanobut.logger.Logger;

/**
 * Created by JC on 2018/01/19.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static BaseActivity activity;
    protected Toolbar toolbar;

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        ((BookBrowserApplication) UIHelper.getContext()).addActivity(this);
        init();
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (null != toolbar) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    private void init() {
        initEvents();
        initData();
    }

    protected abstract void initEvents();

    protected abstract void initData();

    protected void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    protected void printLog(String tag, String message) {
        Logger.i(tag, message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BookBrowserApplication) UIHelper.getContext()).removeActivity(this);
    }
}
