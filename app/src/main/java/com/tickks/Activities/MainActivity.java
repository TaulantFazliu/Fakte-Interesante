package com.tickks.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.tickks.Factories.ColorFactory;
import com.tickks.Factories.FactFactory;
import com.tickks.R;

public class MainActivity extends AppCompatActivity {

  FactFactory factFactory;
  ColorFactory colorFactory = new ColorFactory();

  TextView factText;
  Button showAnotherFactButton;
  private ConstraintLayout mainView;
  Button showAllFacts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    factFactory=new FactFactory(this);

    factText = findViewById(R.id.fun_fact_view);
    mainView = findViewById(R.id.main_layout);
    showAnotherFactButton = findViewById(R.id.show_another_fact);
    showAllFacts = findViewById(R.id.show_all);


    showAnotherFactButton.setOnClickListener(v ->
            changeFact()
    );

    showAllFacts.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,AllFactActivity.class);
        startActivity(intent);
      }
    });


  }

  private void changeFact() {
    String randomFact = factFactory.getFact();
    String randomColor = colorFactory.getColor();
    int color = Color.parseColor(randomColor);
    factText.setText(randomFact);
    mainView.setBackgroundColor(color);
    showAnotherFactButton.setTextColor(color);
    showAllFacts.setTextColor(color);
  }

}
