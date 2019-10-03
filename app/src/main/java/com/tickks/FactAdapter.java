package com.tickks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.util.zip.Inflater;

import static androidx.core.content.ContextCompat.startActivity;

public class FactAdapter extends BaseAdapter {

  private Activity activity;
  String[] list;
  ColorFactory colorFactory=new ColorFactory();
  String []colors=colorFactory.colors;
    int []imazhet={R.drawable.ic_looks_one_black_24dp,
                   R.drawable.ic_looks_two_black_24dp,
                   R.drawable.ic_looks_3_black_24dp,
                   R.drawable.ic_looks_4_black_24dp,
                   R.drawable.ic_looks_5_black_24dp,
                   R.drawable.ic_looks_6_black_24dp,
                   R.drawable.ic_filter_7_black_24dp,
                   R.drawable.ic_filter_8_black_24dp,
                   R.drawable.ic_filter_9_black_24dp,
                   R.drawable.ic_forward_10_black_24dp};


  public FactAdapter(Activity activity,String[] list) {
    this.activity = activity;
    this.list = list;
  }

  @Override
  public int getCount() {

    return list.length;
  }

  @Override
  public String getItem(int position) {
    return list[position];
  }

  @Override
  public long getItemId(int position) {

    return 0;
  }

  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
   View view= LayoutInflater.from(activity).inflate(R.layout.fact_item,null);
   ImageView icon=view.findViewById(R.id.imageView);
      int iconIndex=position%imazhet.length;
      int ikonat=imazhet[iconIndex];
      icon.setImageResource(ikonat);



   String fact=list[position];


   int index=position%colors.length;
    String color=colors[index];


   view.setBackgroundColor(Color.parseColor(color));

//   icon.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);



   Button title=view.findViewById(R.id.fact_text);
   title.setText(fact);
   title.setTextColor(Color.WHITE);
   title.setBackground(Drawable.createFromPath(color));

    return view;
  }
}
