package com.btk.pagingsample.api;

import com.btk.pagingsample.model.ImageDataModel;
import com.btk.pagingsample.model.ImageDataReponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("api")
    Call<ImageDataReponse> getAllImages(
            @Query("key") String query,
            @Query("page") int page,
            @Query("per_page") int perpage);
}
