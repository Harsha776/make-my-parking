package com.example.myparkingtask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SaleInfo implements Serializable {
    @SerializedName("country")
    private String country;

    @SerializedName("isEbook")
    private String isEbook;

    @SerializedName("saleability")
    private String saleability;

    @SerializedName("listPrice")
    private ListPrice listPrice;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getIsEbook ()
    {
        return isEbook;
    }

    public void setIsEbook (String isEbook)
    {
        this.isEbook = isEbook;
    }

    public String getSaleability ()
    {
        return saleability;
    }

    public void setSaleability (String saleability)
    {
        this.saleability = saleability;
    }

    public ListPrice getListPrice ()
    {
        return listPrice;
    }

    public void setListPrice (ListPrice listPrice)
    {
        this.listPrice = listPrice;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+", isEbook = "+isEbook+", saleability = "+saleability+", listPrice = "+listPrice+"]";
    }
}
