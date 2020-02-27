package com.btk.pagingsample.datasource;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.btk.pagingsample.model.ImageDataModel;

public class ImageDataSource extends PageKeyedDataSource<Integer, ImageDataModel> {

    public static final int PAGE_SIZE = 50;
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }
}
