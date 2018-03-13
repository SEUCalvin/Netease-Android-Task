package com.jc.bookbrowser.model.source;

import com.jc.bookbrowser.common.Constant;
import com.jc.bookbrowser.entity.http.BaseResponse;
import com.jc.bookbrowser.entity.http.BookListResponse;
import com.jc.bookbrowser.model.DataServiceFactory;
import com.jc.bookbrowser.model.IBookListModel;
import com.jc.bookbrowser.model.RequestListener;
import com.jc.bookbrowser.model.service.IBookListService;

import java.net.UnknownHostException;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JC on 2018/01/22.
 */

public class BookListModel implements IBookListModel {
    @Override
    public void loadBookList(String q, String tag, int start, int count, String fields, final RequestListener listener) {
        IBookListService bookListService = DataServiceFactory.createService(Constant.BASE_URL,IBookListService.class);
        bookListService.getBookList(q,tag,start,count,fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<BookListResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof UnknownHostException) {
                            listener.onFailed(null);
                            return;
                        }
                        listener.onFailed(new BaseResponse(404,e.getMessage()));
                    }

                    @Override
                    public void onNext(Response<BookListResponse> bookListResponse) {
                        if (bookListResponse.isSuccessful()) {
                            listener.onCompleted(bookListResponse.body());
                        } else {
                            listener.onFailed(new BaseResponse(bookListResponse.code(),bookListResponse.message()));
                        }

                    }
                });

    }

    @Override
    public void cancelLoading() {

    }
}
