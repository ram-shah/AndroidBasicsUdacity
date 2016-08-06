package com.example.android.googlebooklisting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    /** URL to query the Google Books API for book information */
    private static final String GOOGLE_BOOK_REQUEST_BASE_URL =
            "https://www.googleapis.com/books/v1/volumes?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Read the search keyword entered by the user
                EditText keywordEditView = (EditText) findViewById(R.id.keyword_edit_text);
                String keyword = keywordEditView.getText().toString();

                // Kick off an {@link AsyncTask} to perform the network request
                BookAsyncTask task = new BookAsyncTask();
                task.execute(keyword);
            }
        });
    }

    /**
     * Update the screen to display information of all {@link Book} objects.
     */
    private void updateUi(ArrayList<Book> books) {
        TextView defaultTextView = (TextView) findViewById(R.id.default_text_view);

        // Find a reference to the {@link ListView} in the layout
        ListView bookListView = (ListView) findViewById(R.id.list);

        if ((books == null) || (books.isEmpty())) {
            // No data to show
            defaultTextView.setVisibility(View.VISIBLE);
            bookListView.setVisibility(View.GONE);
            defaultTextView.setText(getResources().getString(R.string.no_data));
        } else {
            defaultTextView.setVisibility(View.GONE);
            bookListView.setVisibility(View.VISIBLE);

            // Create a new {@link BookAdapter} of books
            final BookAdapter adapter = new BookAdapter( this, R.layout.book_list_item, books);

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            bookListView.setAdapter(adapter);
        }
    }

    /**
     * {@link AsyncTask} to perform the network request on a background thread
     */
    private class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(String... keyword) {
            // Create URL object
            URL url = createUrl(GOOGLE_BOOK_REQUEST_BASE_URL, keyword[0]);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
                Log.d(LOG_TAG, jsonResponse);
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error while retrieving book information");
            }

            // Extract relevant fields from the JSON response and create a list of {@link Book} objects
            ArrayList<Book> books = QueryUtils.extractBooks(jsonResponse);

            // Return the {@link Book} object as the result fo the {@link BookAsyncTask}
            return books;
        }

        /**
         * Update the screen with the given book (which was the result of the
         * {@link BookAsyncTask}).
         */
        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            updateUi(books);
        }

        /**
         * Returns new URL object from the given string URL.
         */
        private URL createUrl(String baseUrl, String keyword) {
            URL url = null;
            try {
                String requestUrl = baseUrl + "q=" + URLEncoder.encode(keyword, "UTF-8") + "&maxResults=15";
                url = new URL(requestUrl);
            } catch (Exception exception) {
                Log.e(LOG_TAG, "Error with creating URL", exception);
                return null;
            }
            return url;
        }

        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";

            if (url == null) {
                return  jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                int httpResponseErrorCode = urlConnection.getResponseCode();
                if (httpResponseErrorCode != 200) {
                    Log.e(LOG_TAG, "Error Response code: " + httpResponseErrorCode);
                    return jsonResponse;
                }
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } catch (IOException e) {
                //Handle the exception
                Log.e(LOG_TAG, "Cannot retrieve book information");
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }
    }
}
