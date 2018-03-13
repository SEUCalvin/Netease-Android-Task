package com.jc.bookbrowser.presenter;

public interface IBookListPresenter {

    void loadBooks(String q, String tag, int start, int count, String fields);

    void cancelLoading();

}
