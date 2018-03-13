package com.jc.bookbrowser.model.service;

import com.jc.bookbrowser.entity.http.BookSeriesListResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
public interface IRecommendedBookService {
    @GET("book/series/{seriesId}/books")
    Observable<Response<BookSeriesListResponse>> getBookSeries(@Path("seriesId") String seriesId, @Query("start") int start, @Query("count") int count, @Query("fields") String fields);
}
