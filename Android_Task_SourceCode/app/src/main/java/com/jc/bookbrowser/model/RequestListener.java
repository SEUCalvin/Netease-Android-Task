package com.jc.bookbrowser.model;

import com.jc.bookbrowser.entity.http.BaseResponse;

/**
 * Created by JiCe on 2018/01/20.
 */
public interface RequestListener {
    void onCompleted(Object result);
    void onFailed(BaseResponse message);
}
