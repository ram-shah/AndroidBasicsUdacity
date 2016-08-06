package com.example.android.sanfrancisco;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramshah on 7/27/16.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {
    private int mBackgroundColor;

    public PlaceAdapter(Context context, ArrayList<Place> places, int backgroundColor) {
        super(context, 0, places);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // check if the existing view is being reused, otherwise infate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.place_list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        final Place currentPlace = getItem(position);

        // Find the TextView in the place_list_item.xml layout with the ID name_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name from the current Place object and
        // set this text on the name TextView
        nameTextView.setText(currentPlace.getName());

        // Find the TextView in the place_list_item.xml layout with the ID address_text_view
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the address from the current Place object and
        // set this text on the address TextView
        addressTextView.setText(currentPlace.getAddress());

        // Find the TextView in the place_list_item.xml layout with the ID phone_text_view
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone_text_view);
        if (currentPlace.hasPhone()) {
            // Get the phone from the current Place object and
            // set this text on the phone TextView
            phoneTextView.setText(currentPlace.getPhone());
            phoneTextView.setVisibility(View.VISIBLE);
        } else {
            phoneTextView.setVisibility(View.GONE);
        }
        // Find the TextView in the place_list_item.xml layout with the ID hours_text_view
        TextView hoursTextView = (TextView) listItemView.findViewById(R.id.hours_text_view);
        if (currentPlace.hasHours()) {
            // Get the hours from the current Place object and
            // set this text on the hours TextView
            hoursTextView.setText(currentPlace.getHours());
            hoursTextView.setVisibility(View.VISIBLE);
        } else {
            hoursTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the place_list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image from the current Place object and
        // set this image on the ImageView
        if (currentPlace.hasImage()) {
            imageView.setImageResource(currentPlace.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
