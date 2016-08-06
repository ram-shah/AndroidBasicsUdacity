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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getResources().getString(R.string.restaurant1_name),
                        getResources().getString(R.string.restaurant1_address),
                        getResources().getString(R.string.restaurant1_phone),
                        getResources().getString(R.string.restaurant1_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant2_name),
                        getResources().getString(R.string.restaurant2_address),
                        getResources().getString(R.string.restaurant2_phone),
                        getResources().getString(R.string.restaurant2_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant3_name),
                        getResources().getString(R.string.restaurant3_address),
                        getResources().getString(R.string.restaurant3_phone),
                        getResources().getString(R.string.restaurant3_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant4_name),
                        getResources().getString(R.string.restaurant4_address),
                        getResources().getString(R.string.restaurant4_phone),
                        getResources().getString(R.string.restaurant4_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant5_name),
                        getResources().getString(R.string.restaurant5_address),
                        getResources().getString(R.string.restaurant5_phone),
                        getResources().getString(R.string.restaurant5_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant6_name),
                        getResources().getString(R.string.restaurant6_address),
                        getResources().getString(R.string.restaurant6_phone),
                        getResources().getString(R.string.restaurant6_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant7_name),
                        getResources().getString(R.string.restaurant7_address),
                        getResources().getString(R.string.restaurant7_phone),
                        getResources().getString(R.string.restaurant7_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant8_name),
                        getResources().getString(R.string.restaurant8_address),
                        getResources().getString(R.string.restaurant8_phone),
                        getResources().getString(R.string.restaurant8_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant9_name),
                        getResources().getString(R.string.restaurant9_address),
                        getResources().getString(R.string.restaurant9_phone),
                        getResources().getString(R.string.restaurant9_hours)));
        places.add(new Place(getResources().getString(R.string.restaurant10_name),
                        getResources().getString(R.string.restaurant10_address),
                        getResources().getString(R.string.restaurant10_phone),
                        getResources().getString(R.string.restaurant10_hours)));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link PLace}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurants);

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
