package com.example.android.googlebooklisting;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving book data from Google Book API.
 */
public final class QueryUtils {

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link Book} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Book> extractBooks(String jsonResponse) {

        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding books to
        ArrayList<Book> books = new ArrayList<>();

        // Try to parse the jsonResponse. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Parse the response given by the jsonResponse string and
            // build up a list of Book objects with the corresponding data.
            JSONObject root = new JSONObject(jsonResponse);
            JSONArray items = root.getJSONArray("items");

            for (int i=0; i<items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                JSONObject volumeInfo = item.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                JSONArray authors;
                try {

                    authors = volumeInfo.getJSONArray("authors");

                } catch (JSONException e) {
                    // There may be a scenario where the authors information is not
                    // present in the jsonResponse. In this case continue to next book
                    Log.e("QueryUtils", "Problem getting the author list from JSON results", e);
                    books.add(new Book(title, null));
                    continue;
                }

                ArrayList<String> authorsList = new ArrayList<>();
                for (int j=0; j<authors.length(); j++) {
                    String author = authors.getString(j);
                    authorsList.add(author);
                }
                books.add(new Book(title, authorsList));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the book JSON results", e);
        }

        // Return the list of books
        return books;
    }
}
