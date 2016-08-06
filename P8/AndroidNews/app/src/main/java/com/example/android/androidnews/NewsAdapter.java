package com.example.android.androidnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramshah on 8/3/16.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOG_TAG = NewsAdapter.class.getName();

    public NewsAdapter(Context context, List<News> newsItems) {
        super(context, 0, newsItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        ViewHolder holder;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item,
                    parent, false);
            holder = new ViewHolder();
            holder.titleTextView = (TextView) listViewItem.findViewById(R.id.title_text_view);
            holder.authorTextView = (TextView) listViewItem.findViewById(R.id.author_text_view);
            listViewItem.setTag(holder);
        } else {
            holder = (ViewHolder) listViewItem.getTag();
        }

        News currentNewsItem = getItem(position);

        holder.titleTextView.setText(currentNewsItem.getTitle());
        holder.authorTextView.setText(currentNewsItem.getAuthor());

        return listViewItem;
    }

    static class ViewHolder {
        private TextView titleTextView;
        private TextView authorTextView;
    }
}
