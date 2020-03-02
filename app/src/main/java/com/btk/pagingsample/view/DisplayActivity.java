package com.btk.pagingsample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.btk.pagingsample.R;
import com.btk.pagingsample.databinding.ActivityMainBinding;
import com.btk.pagingsample.model.ImageDataModel;
import com.btk.pagingsample.viewmodel.DisplayViewModel;
import com.btk.pagingsample.adapter.Imagepagedadapter;
import com.facebook.shimmer.ShimmerFrameLayout;

public class DisplayActivity extends AppCompatActivity {

    private final String TAG = DisplayActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;
    private DisplayViewModel viewModel;
    private Imagepagedadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(DisplayActivity.this,R.layout.activity_main);
        initviews();
        viewModel = ViewModelProviders.of(this).get(DisplayViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        observeData();
    }

    private void observeData() {
        viewModel.getAllImages().observe(this, new Observer<PagedList<ImageDataModel>>() {
            @Override
            public void onChanged(PagedList<ImageDataModel> imageDataModels) {
                Log.v(TAG,"==>>onChanged:"+imageDataModels.size());
                adapter.submitList(imageDataModels);
            }
        });
        mBinding.rvImage.setVisibility(View.VISIBLE);
        mBinding.rvImage.setAdapter(adapter);
    }

    private void initviews() {
        mBinding.rvImage.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvImage.setHasFixedSize(true);
        adapter = new Imagepagedadapter(this);
    }
}
