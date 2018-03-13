package com.jc.bookbrowser.view;

/**
 * Created by JC on 2018/01/22.
 */

public interface IBookListView {
    void showMessage(String msg);

    void showProgress();

    void hideProgress();

    void refreshData(Object data);

    void addData(Object data);
}
