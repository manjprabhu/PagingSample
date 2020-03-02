package com.btk.pagingsample.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.btk.pagingsample.datasource.ImageDataSourceFactory;
import com.btk.pagingsample.datasource.ImageDataSource;
import com.btk.pagingsample.model.ImageDataModel;

public class DisplayViewModel extends ViewModel {

    public LiveData<PagedList<ImageDataModel>> pagedList;

    private final String TAG = DisplayViewModel.class.getSimpleName();

    public DisplayViewModel() {
        Log.v(TAG,"==>> getAllImages");
        ImageDataSourceFactory dataSourceFactory = new ImageDataSourceFactory();

        PagedList.Config config = (new PagedList.Config.Builder())
                 .setEnablePlaceholders(false)
                .setPageSize(ImageDataSource.PAGE_SIZE).build();

        pagedList = new LivePagedListBuilder(dataSourceFactory,config).build();
        Log.v(TAG,"==>>liveData:"+pagedList);
    }

    public LiveData<PagedList<ImageDataModel>> getAllImages() {
        Log.v(TAG,"==>> getAllImages");
        return pagedList;
    }
}
