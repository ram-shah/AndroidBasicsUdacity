package com.example.android.sanfrancisco;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartUpsFragment extends Fragment {

    public StartUpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getResources().getString(R.string.startups1_name),
                        getResources().getString(R.string.startups1_address),
                        R.drawable.dropbox));
        places.add(new Place(getResources().getString(R.string.startups2_name),
                        getResources().getString(R.string.startups2_address),
                        R.drawable.shyp));
        places.add(new Place(getResources().getString(R.string.startups3_name),
                        getResources().getString(R.string.startups3_address),
                        R.drawable.uber));
        places.add(new Place(getResources().getString(R.string.startups4_name),
                        getResources().getString(R.string.startups4_address),
                        R.drawable.slack));
        places.add(new Place(getResources().getString(R.string.startups5_name),
                        getResources().getString(R.string.startups5_address),
                        R.drawable.pinterest));
        places.add(new Place(getResources().getString(R.string.startups6_name),
                        getResources().getString(R.string.startups6_address),
                        R.drawable.udemy));
        places.add(new Place(getResources().getString(R.string.startups7_name),
                        getResources().getString(R.string.startups7_address),
                        R.drawable.asana));
        places.add(new Place(getResources().getString(R.string.startups8_name),
                        getResources().getString(R.string.startups8_address),
                        R.drawable.stripe));
        places.add(new Place(getResources().getString(R.string.startups9_name),
                        getResources().getString(R.string.startups9_address),
                        R.drawable.postmates));
        places.add(new Place(getResources().getString(R.string.startups10_name),
                        getResources().getString(R.string.startups10_address),
                        R.drawable.airbnb));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link PLace}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_startups);

        // Find the {@link ListView} object in the view hierarchy of the {@link Fragment}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each place in the list of places.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name adapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}
