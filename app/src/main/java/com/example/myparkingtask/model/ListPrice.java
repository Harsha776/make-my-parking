package com.example.myparkingtask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListPrice implements Serializable {

    @SerializedName("amount")
    private String amount;

    @SerializedName("currencyCode")
    private String currencyCode;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getCurrencyCode ()
    {
        return currencyCode;
    }

    public void setCurrencyCode (String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", currencyCode = "+currencyCode+"]";
    }
}
