package com.example.myparkingtask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VolumeInfo implements Serializable {

    @SerializedName("pageCount")
    private String pageCount;

    @SerializedName("printType")
    private String printType;

    @SerializedName("previewLink")
    private String previewLink;

    @SerializedName("canonicalVolumeLink")
    private String canonicalVolumeLink;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    @SerializedName("title")
    private String title;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("publishedDate")
    private String publishedDate;

    @SerializedName("categories")
    private String[] categories;

    @SerializedName("maturityRating")
    private String maturityRating;

    @SerializedName("allowAnonLogging")
    private String allowAnonLogging;

    @SerializedName("contentVersion")
    private String contentVersion;

    @SerializedName("authors")
    private String[] authors;

    @SerializedName("infoLink")
    private String infoLink;
    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    public String getPageCount ()
    {
        return pageCount;
    }

    public void setPageCount (String pageCount)
    {
        this.pageCount = pageCount;
    }

    public String getPrintType ()
    {
        return printType;
    }

    public void setPrintType (String printType)
    {
        this.printType = printType;
    }

    public String getPreviewLink ()
    {
        return previewLink;
    }

    public void setPreviewLink (String previewLink)
    {
        this.previewLink = previewLink;
    }

    public String getCanonicalVolumeLink ()
    {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink (String canonicalVolumeLink)
    {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getPublisher ()
    {
        return publisher;
    }

    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
    }

    public String getPublishedDate ()
    {
        return publishedDate;
    }

    public void setPublishedDate (String publishedDate)
    {
        this.publishedDate = publishedDate;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    public String getMaturityRating ()
    {
        return maturityRating;
    }

    public void setMaturityRating (String maturityRating)
    {
        this.maturityRating = maturityRating;
    }

    public String getAllowAnonLogging ()
    {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging (String allowAnonLogging)
    {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion ()
    {
        return contentVersion;
    }

    public void setContentVersion (String contentVersion)
    {
        this.contentVersion = contentVersion;
    }

    public String[] getAuthors ()
    {
        return authors;
    }

    public void setAuthors (String[] authors)
    {
        this.authors = authors;
    }

    public String getInfoLink ()
    {
        return infoLink;
    }

    public void setInfoLink (String infoLink)
    {
        this.infoLink = infoLink;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
