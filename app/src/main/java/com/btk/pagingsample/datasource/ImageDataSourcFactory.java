package com.btk.pagingsample.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.btk.pagingsample.model.ImageDataModel;

public class ImageDataSourcFactory extends DataSource.Factory<Integer, ImageDataModel> {

    private MutableLiveData<PageKeyedDataSource<Integer,ImageDataModel>> mImageLiveData = new MutableLiveData();

    @Override
    public DataSource create() {
        ImageDataSource imageDataSource = new ImageDataSource();
        mImageLiveData.postValue(imageDataSource);
        return imageDataSource;
    }

    public LiveData<PageKeyedDataSource<Integer,ImageDataModel>> getData() {
        return mImageLiveData;
    }
}
