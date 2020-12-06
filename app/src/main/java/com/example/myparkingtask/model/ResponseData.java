package com.example.myparkingtask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseData implements Serializable {
    @SerializedName("totalItems")
    private String totalItems;

    @SerializedName("kind")
    private String kind;

    @SerializedName("items")
    private ArrayList<Items> items;

    public String getTotalItems ()
    {
        return totalItems;
    }

    public void setTotalItems (String totalItems)
    {
        this.totalItems = totalItems;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public ArrayList<Items> getItems ()
    {
        return items;
    }

    public void setItems (ArrayList<Items> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [totalItems = "+totalItems+", kind = "+kind+", items = "+items+"]";
    }
}
