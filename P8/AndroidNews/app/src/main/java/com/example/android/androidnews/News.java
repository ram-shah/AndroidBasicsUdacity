package com.example.android.androidnews;

/**
 * Created by ramshah on 8/3/16.
 */
public class News {
    private String mTitle;
    private String mAuthor;
    private String mWebUrl;

    public News(String title, String author, String webUrl) {
        this.mTitle = title;
        this.mAuthor = author;
        this.mWebUrl = webUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getWebUrl() {
        return mWebUrl;
    }
}
