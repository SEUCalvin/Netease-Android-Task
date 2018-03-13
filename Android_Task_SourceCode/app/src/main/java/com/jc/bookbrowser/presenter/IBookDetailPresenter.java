package com.jc.bookbrowser.presenter;

public interface IBookDetailPresenter {
    void loadComments(String bookId, int start, int count, String fields);

    void loadRecommendedBooks(String bookId, int start, int count, String fields);

    void cancelLoading();
}
