package com.btk.pagingsample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.btk.pagingsample.datasource.ImageDataSourcFactory;
import com.btk.pagingsample.datasource.ImageDataSource;
import com.btk.pagingsample.model.ImageDataModel;

public class DisplayViewModel extends ViewModel {

    private LiveData<PagedList<ImageDataModel>> liveData;

    private final String TAG = DisplayViewModel.class.getSimpleName();

    public DisplayViewModel() {
        ImageDataSourcFactory dataSourceFactory = new ImageDataSourcFactory();

        PagedList.Config config = new PagedList.Config.Builder()
                 .setEnablePlaceholders(false)
                .setPageSize(ImageDataSource.PAGE_SIZE).build();

        liveData = (new LivePagedListBuilder(dataSourceFactory,config)).build();
    }

    public LiveData<PagedList<ImageDataModel>> getAllImages() {
        return liveData;
    }
}
