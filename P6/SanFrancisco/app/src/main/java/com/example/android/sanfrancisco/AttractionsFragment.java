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
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getResources().getString(R.string.attraction1_name),
                getResources().getString(R.string.attraction1_address)));
        places.add(new Place(getResources().getString(R.string.attraction2_name),
                getResources().getString(R.string.attraction2_address)));
        places.add(new Place(getResources().getString(R.string.attraction3_name),
                getResources().getString(R.string.attraction3_address)));
        places.add(new Place(getResources().getString(R.string.attraction4_name),
                getResources().getString(R.string.attraction4_address)));
        places.add(new Place(getResources().getString(R.string.attraction5_name),
                getResources().getString(R.string.attraction5_address)));
        places.add(new Place(getResources().getString(R.string.attraction6_name),
                getResources().getString(R.string.attraction6_address)));
        places.add(new Place(getResources().getString(R.string.attraction7_name),
                getResources().getString(R.string.attraction7_address)));
        places.add(new Place(getResources().getString(R.string.attraction8_name),
                getResources().getString(R.string.attraction8_address)));
        places.add(new Place(getResources().getString(R.string.attraction9_name),
                getResources().getString(R.string.attraction9_address)));
        places.add(new Place(getResources().getString(R.string.attraction10_name),
                getResources().getString(R.string.attraction10_address)));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link PLace}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_attractions);

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
