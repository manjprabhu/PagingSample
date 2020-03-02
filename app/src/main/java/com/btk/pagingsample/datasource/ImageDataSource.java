package com.btk.pagingsample.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.btk.pagingsample.api.Api;
import com.btk.pagingsample.api.RetrofitClient;
import com.btk.pagingsample.model.ImageDataModel;
import com.btk.pagingsample.model.ImageDataReponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageDataSource extends PageKeyedDataSource<Integer, ImageDataModel> {

    private String TAG = ImageDataSource.class.getSimpleName();
    public static final int PAGE_SIZE = 50;
    private final int FIRST_PAGE = 1;
    private final String API_KEY = "";
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer,ImageDataModel> callback) {

        Api api = RetrofitClient.getInstance().create(Api.class);
        api.getAllImages(API_KEY,FIRST_PAGE,5).enqueue(new Callback<ImageDataReponse>() {
            @Override
            public void onResponse(Call<ImageDataReponse> call, Response<ImageDataReponse> response) {
                if(response.code() == 200 && response.body()!=null) {
                    Log.v(TAG,"==>> onResponse:"+response.body().getAllImages().size());
                    callback.onResult(response.body().getAllImages(),null,FIRST_PAGE+1);
                }
            }

            @Override
            public void onFailure(Call<ImageDataReponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer,ImageDataModel> callback) {
        Api api = RetrofitClient.getInstance().create(Api.class);
        api.getAllImages(API_KEY,params.key,5).enqueue(new Callback<ImageDataReponse>() {
                    @Override
                    public void onResponse(Call<ImageDataReponse> call, Response<ImageDataReponse> response) {
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            Log.v(TAG,"==>> loadBefore onResponse:"+response.body().getAllImages().size());
                            callback.onResult(response.body().getAllImages(),adjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<ImageDataReponse> call, Throwable t) {
                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer,ImageDataModel> callback) {
        Api api = RetrofitClient.getInstance().create(Api.class);

        api.getAllImages(API_KEY,params.key,5).enqueue(new Callback<ImageDataReponse>() {
                    @Override
                    public void onResponse(Call<ImageDataReponse> call, Response<ImageDataReponse> response) {
                        if (response.body() != null && true) {
                            Log.v(TAG,"==>> loadAfter onResponse:"+response.body().getAllImages().size());
                            callback.onResult(response.body().getAllImages(), params.key + 1);
                        }
                    }
                    @Override
                    public void onFailure(Call<ImageDataReponse> call, Throwable t) {
                    }
                });
    }
}
