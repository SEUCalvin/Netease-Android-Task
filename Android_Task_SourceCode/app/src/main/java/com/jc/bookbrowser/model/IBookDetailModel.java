package com.jc.bookbrowser.model;

public interface IBookDetailModel {
    /**
     * get book comments
     * */
    void loadBookComments(String bookID,int start,int count,String fields,RequestListener requestListener);

    /**
     * get recommended books
     * */
    void loadRecommendedBooks(String seriesId, int start, int count, String fields, RequestListener listener);

    /**
     * cancel loading
     * */
    void cancelLoading();

}
