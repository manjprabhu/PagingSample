package com.btk.pagingsample.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final String TAG  = RetrofitClient.class.getSimpleName();

    private static final String BASE_URL ="https://pixabay.com/";
    private static Retrofit INSTANCE = null;
    private static final  HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    private static OkHttpClient okHttpClient;

    public static Retrofit getInstance() {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
        }

        if(INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return INSTANCE;
    }
}
