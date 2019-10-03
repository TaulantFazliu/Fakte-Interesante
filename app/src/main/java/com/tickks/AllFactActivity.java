package com.tickks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AllFactActivity extends AppCompatActivity {

  FactFactory factFactory = new FactFactory();

  ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_fact);

    FragmentManager fragmentManager =getSupportFragmentManager();
    fragmentManager
            .beginTransaction().add(R.id.main_layout,new AllFactsFragment(),"Aktiviteti")
            .commit();

//
  }
}
