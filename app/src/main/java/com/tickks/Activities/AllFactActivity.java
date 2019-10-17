package com.tickks.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.tickks.Fragments.AllFactFragment;
import com.tickks.R;

public class AllFactActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_fact);

    FragmentManager fragmentManager =getSupportFragmentManager();
    fragmentManager
            .beginTransaction()
            .add(R.id.main_layout,new AllFactFragment(),"Aktiviteti")
            .commit();

//
  }
}
