package com.btk.pagingsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.btk.pagingsample.R;
import com.btk.pagingsample.model.ImageDataModel;
import com.bumptech.glide.Glide;

public class Imagepagedadapter extends PagedListAdapter<ImageDataModel, Imagepagedadapter.ImageViewHolder> {

    private final String TAG = Imagepagedadapter.class.getSimpleName();
    private Context mContext;

    private static final DiffUtil.ItemCallback<ImageDataModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ImageDataModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull ImageDataModel oldItem, @NonNull ImageDataModel newItem) {
                    return (oldItem.getId() == newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull ImageDataModel oldItem, @NonNull ImageDataModel newItem) {
                    return (oldItem.equals(newItem));
                }
            };

    public Imagepagedadapter(Context context) {
        super(DIFF_CALLBACK);
        this.mContext = context;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        final ImageDataModel model = getItem(position);
        Glide.with(mContext).load(model.getLargeImageURL()).into(holder.imageView);
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }
}
