package com.jc.bookbrowser.model;

/**
 * Created by JC on 2018/01/24.
 */
public interface IBookListModel {
    void loadBookList(String q,String tag,int start,int count,String fields,RequestListener listener);
    void cancelLoading();
}
