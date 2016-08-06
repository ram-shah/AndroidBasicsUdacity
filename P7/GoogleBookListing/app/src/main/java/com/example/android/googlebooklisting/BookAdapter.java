package com.example.android.googlebooklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramshah on 7/31/16.
 */
public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, int resource, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item, parent, false);
        }

        Book currentbook = getItem(position);

        // Display the book title in the UI
        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_text_view);
        titleTextView.setText(currentbook.getTitle());

        // Display the book author in the UI
        TextView authorTextView = (TextView) listViewItem.findViewById(R.id.author_text_view);
        if (currentbook.getAuthor() == null) {
            authorTextView.setText("");
        } else {
            StringBuilder authors = new StringBuilder();
            String author;
            for (int i = 0; i < currentbook.getAuthor().size(); i++) {
                if (i == 0) {
                    author = currentbook.getAuthor().get(i);
                } else {
                    author = ", " + currentbook.getAuthor().get(i);
                }
                authors.append(author);
            }
            authorTextView.setText(authors.toString());
        }

        return listViewItem;
    }
}
