package com.btk.pagingsample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;

import android.os.Bundle;

import com.btk.pagingsample.model.ImageDataModel;
import com.btk.pagingsample.viewmodel.DisplayViewModel;

public class DisplayActivity extends AppCompatActivity {

    private DisplayViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(DisplayViewModel.class);
    }

    private void observeData() {
        viewModel.getAllImages().observe(this, new Observer<PagedList<ImageDataModel>>() {
            @Override
            public void onChanged(PagedList<ImageDataModel> imageDataModels) {

            }
        });
    }


}
