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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFactsFragment extends Fragment {

    FactFactory factFactory=new FactFactory();



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
        FloatingActionButton button= getView().findViewById(R.id.fab);
        ListView listView=view.findViewById(R.id.list_view);;
        ArrayList<String> facts = factFactory.newFaktet;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_layout,new AddFact(), "ADD_NEW")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
