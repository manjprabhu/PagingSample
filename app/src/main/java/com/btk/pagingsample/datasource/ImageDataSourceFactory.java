package com.btk.pagingsample.datasource;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.btk.pagingsample.model.ImageDataModel;

public class ImageDataSourceFactory extends DataSource.Factory<Integer, ImageDataModel> {

    private String TAG = ImageDataSourceFactory.class.getSimpleName();
    private MutableLiveData<ImageDataSource> mImageLiveData;

    public ImageDataSourceFactory() {
        mImageLiveData = new MutableLiveData<>();
    }
    @Override
    public DataSource create() {
        Log.v(TAG,"==>> ImageDataSourceFactory");
        ImageDataSource imageDataSource = new ImageDataSource();
        mImageLiveData.postValue(imageDataSource);
        return imageDataSource;
    }
}
