package com.btk.pagingsample.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDataReponse {

    @SerializedName("total")
    @Expose
    private Integer total;

    @SerializedName("totalHits")
    @Expose
    private Integer totalHits;

    @SerializedName("hits")
    @Expose
    private List<ImageDataModel> image = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public List<ImageDataModel> getAllImages() {
        return image;
    }

    public void setHits(List<ImageDataModel> image) {
        this.image = image;
    }
}