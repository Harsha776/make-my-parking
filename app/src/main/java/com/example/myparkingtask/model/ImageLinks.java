package com.example.myparkingtask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageLinks  implements Serializable {

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("smallThumbnail")
    private String smallThumbnail;

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getSmallThumbnail ()
    {
        return smallThumbnail;
    }

    public void setSmallThumbnail (String smallThumbnail)
    {
        this.smallThumbnail = smallThumbnail;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [thumbnail = "+thumbnail+", smallThumbnail = "+smallThumbnail+"]";
    }
}
