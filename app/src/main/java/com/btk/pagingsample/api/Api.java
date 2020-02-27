package com.btk.pagingsample.api;

import com.btk.pagingsample.model.ImageDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("api")
    Call<ImageDataModel> getAllImages(
            @Query("key") String query,
            @Query("page") String page,
            @Query("per_page") String perpage);
}
