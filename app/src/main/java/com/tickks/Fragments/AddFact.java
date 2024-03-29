package com.tickks.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tickks.Factories.FactFactory;
import com.tickks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFact extends Fragment {


    public AddFact() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView addFactText= view.findViewById(R.id.new_fact_view);
        EditText faktiIRi=view.findViewById(R.id.editText);
        Button butoniCancel=view.findViewById(R.id.cancel_buton);
        Button butoniSave=view.findViewById(R.id.save_button);

        butoniCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        butoniSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFact = faktiIRi.getText().toString();

                if (validate(newFact)) {
                    addFact(newFact);
                } else {
                    faktiIRi.setError("The fact should have more then 5 characters");
                }
            }
        });

    }

    private boolean validate(String newFact) {
        Toast.makeText(getActivity(), newFact, Toast.LENGTH_SHORT).show();
        newFact = newFact.trim();
        if (newFact.length() < 5) {
            return false;
        }
        return true;

    }
    private void addFact(String newFact) {
        FactFactory factory = new FactFactory(getContext());
        factory.addFact(newFact);
        getActivity().onBackPressed();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_add_fact, container, false);
    }

}
