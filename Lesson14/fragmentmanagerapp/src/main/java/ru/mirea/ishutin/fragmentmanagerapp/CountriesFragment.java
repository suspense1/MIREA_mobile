package ru.mirea.ishutin.fragmentmanagerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesFragment extends Fragment {

    public static CountriesFragment newInstance(String param1) {
        Bundle args = new Bundle();
        CountriesFragment fragment = new CountriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ListView listView;
    private Map<String, String> data = new HashMap<String, String>() {{
        put("Germany", "A central European country known for its engineering, history, and beer.");
        put("Australia", "An island continent in the Southern Hemisphere known for its unique wildlife and stunning natural beauty.");
        put("India", "A country in South Asia known for its ancient civilization, vibrant traditions, and Bollywood films.");
        put("Mexico", "A country in North America known for its ancient civilizations, vibrant culture, and spicy cuisine.");
        put("South Africa", "A country located at the southern tip of Africa, known for its diverse wildlife and vibrant culture.");
    }};

    private ShareViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        listView = view.findViewById(R.id.countries_list_view);
        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        List<String> names = new ArrayList<>(data.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String targetName = names.get(position);
            viewModel.setSomeValue(data.get(targetName));
        });

        return view;
    }
}