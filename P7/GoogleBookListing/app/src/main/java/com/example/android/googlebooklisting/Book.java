package com.example.android.googlebooklisting;

import java.util.ArrayList;

/**
 * Created by ramshah on 7/31/16.
 */
public class Book{
    private String mTitle;
    private ArrayList<String> mAuthors;

    public Book(String title, ArrayList<String> authors) {
        this.mTitle = title;
        this.mAuthors = authors;
    }

    public String getTitle() {
        return mTitle;
    }

    public ArrayList<String> getAuthor() {
        return mAuthors;
    }
}
