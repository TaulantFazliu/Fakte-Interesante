package com.tickks;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFactsFragment extends Fragment {

    FloatingActionButton button= getView().findViewById(R.id)
    FactFactory factFactory;



    public AllFactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_facts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView listView=view.findViewById(R.id.list_view);;

//
    String[] facts = factFactory.faktet;

//    ArrayAdapter<String> adapter =
//        new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, facts);

    //listView.setAdapter(adapter);

//    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//      @Override
//      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(AllFactActivity.this, "You have selected item: " + position, Toast.LENGTH_SHORT).show();
//      }
//    });



    FactAdapter ourAdapter = new FactAdapter(getActivity(),facts);
    listView.setAdapter(ourAdapter);
    }
}
