package com.jc.bookbrowser.view;

public interface IBookDetailView {
    void showMessage(String msg);

    void showProgress();

    void hideProgress();

    void showData(Object data);
}
